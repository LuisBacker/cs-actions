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

package io.cloudslang.content.abbyy.utils;

import io.cloudslang.content.abbyy.constants.OutputNames;
import io.cloudslang.content.abbyy.exceptions.AbbyySdkException;
import io.cloudslang.content.constants.ReturnCodes;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.HashMap;
import java.util.Map;

public final class ResultUtils {

    public static Map<String, String> createNewEmptyMap() {
        Map<String, String> results = new HashMap<>();

        results.put(io.cloudslang.content.constants.OutputNames.RETURN_RESULT, StringUtils.EMPTY);
        results.put(OutputNames.TXT_RESULT, StringUtils.EMPTY);
        results.put(OutputNames.XML_RESULT, StringUtils.EMPTY);
        results.put(OutputNames.PDF_URL, StringUtils.EMPTY);
        results.put(OutputNames.TASK_ID, StringUtils.EMPTY);
        results.put(OutputNames.CREDITS, StringUtils.EMPTY);
        results.put(OutputNames.STATUS_CODE, StringUtils.EMPTY);
        results.put(io.cloudslang.content.constants.OutputNames.EXCEPTION, StringUtils.EMPTY);
        results.put(io.cloudslang.content.constants.OutputNames.RETURN_CODE, ReturnCodes.FAILURE);
        results.put(OutputNames.TIMED_OUT, String.valueOf(false));

        return results;
    }


    public static Map<String, String> fromException(Exception ex) {
        Map<String, String> results = (ex instanceof AbbyySdkException && ((AbbyySdkException) ex).getResultsMap() != null) ?
                ((AbbyySdkException) ex).getResultsMap() :
                createNewEmptyMap();

        results.put(io.cloudslang.content.constants.OutputNames.RETURN_RESULT, ex.getMessage());
        results.put(io.cloudslang.content.constants.OutputNames.EXCEPTION, ExceptionUtils.getStackTrace(ex));
        results.put(io.cloudslang.content.constants.OutputNames.RETURN_CODE, ReturnCodes.FAILURE);

        return results;
    }
}
