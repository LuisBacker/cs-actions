/*
 * (c) Copyright 2020 EntIT Software LLC, a Micro Focus company, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.cloudslang.content.abbyy.services;

import io.cloudslang.content.abbyy.constants.*;
import io.cloudslang.content.abbyy.entities.ExportFormat;
import io.cloudslang.content.abbyy.entities.ProcessTextFieldInput;
import io.cloudslang.content.abbyy.exceptions.AbbyySdkException;
import io.cloudslang.content.abbyy.exceptions.ValidationException;
import io.cloudslang.content.abbyy.http.AbbyyApi;
import io.cloudslang.content.abbyy.http.AbbyyApiImpl;
import io.cloudslang.content.abbyy.http.AbbyyResponse;
import io.cloudslang.content.abbyy.validators.AbbyyRequestValidator;
import io.cloudslang.content.abbyy.validators.AbbyyResultValidator;
import io.cloudslang.content.abbyy.validators.ProcessTextFieldValidator;
import io.cloudslang.content.abbyy.validators.XmlResultValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.utils.URIBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class ProcessTextFieldService extends AbstractPostRequestService<ProcessTextFieldInput> {

    private final AbbyyResultValidator xmlResultValidator;


    public ProcessTextFieldService() throws ParserConfigurationException {
        this(new ProcessTextFieldValidator(), null, new AbbyyApiImpl());
    }


    ProcessTextFieldService(@NotNull AbbyyRequestValidator<ProcessTextFieldInput> requestValidator,
                            @Nullable AbbyyResultValidator xmlResultValidator,
                            @NotNull AbbyyApi abbyyApi) {
        super(requestValidator, abbyyApi);
        this.xmlResultValidator = xmlResultValidator != null ? xmlResultValidator :
                new XmlResultValidator(this.abbyyApi, XmlSchemas.PROCESS_TEXT_FIELD);
    }


    @Override
    protected String buildUrl(@NotNull ProcessTextFieldInput input) throws Exception {
        URIBuilder urlBuilder = new URIBuilder()
                .setScheme(input.getLocationId().getProtocol())
                .setHost(String.format(Urls.HOST_TEMPLATE, input.getLocationId().toString(),
                        Endpoints.PROCESS_TEXT_FIELD));

        if (input.getRegion() != null) {
            urlBuilder.addParameter(QueryParams.REGION, input.getRegion().toString());
        }

        if (input.getLanguages() != null && !input.getLanguages().isEmpty()) {
            urlBuilder.addParameter(QueryParams.LANGUAGE, StringUtils.join(input.getLanguages(), ','));
        }

        if (StringUtils.isNotEmpty(input.getLetterSet())) {
            urlBuilder.addParameter(QueryParams.LETTER_SET, input.getLetterSet());
        }

        if (StringUtils.isNotEmpty(input.getRegExp())) {
            urlBuilder.addParameter(QueryParams.REG_EXP, input.getRegExp());
        }

        if (input.getTextType() != null) {
            urlBuilder.addParameter(QueryParams.TEXT_TYPE, input.getTextType().toString());
        }

        urlBuilder.addParameter(QueryParams.ONE_TEXT_LINE, String.valueOf(input.isOneTextLine()));

        urlBuilder.addParameter(QueryParams.ONE_WORD_PER_TEXT_LINE, String.valueOf(input.isOneWordPerTextLine()));

        if (input.getMarkingType() != null) {
            urlBuilder.addParameter(QueryParams.MARKING_TYPE, input.getMarkingType().toString());
        }

        urlBuilder.addParameter(QueryParams.PLACEHOLDERS_COUNT, String.valueOf(input.getPlaceholdersCount()));

        if (input.getWritingStyle() != null) {
            urlBuilder.addParameter(QueryParams.WRITING_STYLE, input.getWritingStyle().toString());
        }

        if (StringUtils.isNotEmpty(input.getDescription())) {
            urlBuilder.addParameter(QueryParams.DESCRIPTION, input.getDescription());
        }

        if (StringUtils.isNotEmpty(input.getPdfPassword())) {
            urlBuilder.addParameter(QueryParams.PDF_PASSWORD, input.getPdfPassword());
        }

        return urlBuilder.build().toString();
    }


    @Override
    protected void handleTaskCompleted(@NotNull ProcessTextFieldInput request, @NotNull AbbyyResponse response,
                                       @NotNull Map<String, String> results) throws Exception {
        super.handleTaskCompleted(request, response, results);

        String xml = getResult(request, response);

        if (xml.startsWith(Misc.BOM_CHAR)) {
            xml = xml.substring(1);
        }

        results.put(OutputNames.XML_RESULT, xml);
        if (request.getDestinationFile() != null) {
            saveClearTextResultOnDisk(request, xml);
        }
    }


    private String getResult(@NotNull ProcessTextFieldInput abbyyInitialRequest, @NotNull AbbyyResponse abbyyPreviousResponse) throws Exception {
        ValidationException validationEx;

        if (abbyyPreviousResponse.getResultUrls().isEmpty()) {
            throw new AbbyySdkException(ExceptionMsgs.EXPORT_FORMAT_AND_RESULT_URLS_DO_NOT_MATCH);
        }
        String resultUrl = abbyyPreviousResponse.getResultUrls().get(0);

        validationEx = this.xmlResultValidator.validateBeforeDownload(abbyyInitialRequest, resultUrl);
        if (validationEx != null) {
            throw validationEx;
        }

        return this.abbyyApi.getResult(abbyyInitialRequest, resultUrl, ExportFormat.XML, null, true);
    }


    private void saveClearTextResultOnDisk(@NotNull ProcessTextFieldInput request, @NotNull String clearText) throws IOException {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(request.getDestinationFile()),
                request.getResponseCharacterSet())) {
            writer.write(clearText);
        }
    }

}
