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

package io.cloudslang.content.abbyy.entities;

import io.cloudslang.content.abbyy.constants.InputNames;
import io.cloudslang.content.abbyy.utils.InputParser;
import io.cloudslang.content.httpclient.entities.HttpClientInputs;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ProcessTextFieldInput implements AbbyyRequest {
    private LocationId locationId;
    private String applicationId;
    private String password;
    private String proxyHost;
    private short proxyPort;
    private String proxyUsername;
    private String proxyPassword;
    private boolean trustAllRoots;
    private String x509HostnameVerifier;
    private String trustKeystore;
    private String trustPassword;
    private int connectTimeout;
    private int socketTimeout;
    private boolean keepAlive;
    private int connectionsMaxPerRoute;
    private int connectionsMaxTotal;
    private String responseCharacterSet;
    private File destinationFile;
    private File sourceFile;
    private Region region;
    private List<String> languages;
    private String letterSet;
    private String regExp;
    private TextType textType;
    private boolean oneTextLine;
    private boolean oneWordPerTextLine;
    private MarkingType markingType;
    private int placeholdersCount;
    private WritingStyle writingStyle;
    private String description;
    private String pdfPassword;


    private ProcessTextFieldInput() {
    }


    public LocationId getLocationId() {
        return locationId;
    }


    public String getApplicationId() {
        return applicationId;
    }


    public String getPassword() {
        return password;
    }


    public String getProxyHost() {
        return proxyHost;
    }


    public short getProxyPort() {
        return proxyPort;
    }


    public String getProxyUsername() {
        return proxyUsername;
    }


    public String getProxyPassword() {
        return proxyPassword;
    }


    public boolean isTrustAllRoots() {
        return trustAllRoots;
    }


    public String getX509HostnameVerifier() {
        return x509HostnameVerifier;
    }


    public String getTrustKeystore() {
        return trustKeystore;
    }


    public String getTrustPassword() {
        return trustPassword;
    }


    public int getConnectTimeout() {
        return connectTimeout;
    }


    public int getSocketTimeout() {
        return socketTimeout;
    }


    public boolean isKeepAlive() {
        return keepAlive;
    }


    public int getConnectionsMaxPerRoute() {
        return connectionsMaxPerRoute;
    }


    public int getConnectionsMaxTotal() {
        return connectionsMaxTotal;
    }


    public String getResponseCharacterSet() {
        return responseCharacterSet;
    }


    public File getDestinationFile() {
        return destinationFile;
    }


    public File getSourceFile() {
        return sourceFile;
    }


    public Region getRegion() {
        return region;
    }


    public List<String> getLanguages() {
        return languages;
    }


    public String getLetterSet() {
        return letterSet;
    }


    public String getRegExp() {
        return regExp;
    }


    public TextType getTextType() {
        return textType;
    }


    public boolean isOneTextLine() {
        return oneTextLine;
    }


    public boolean isOneWordPerTextLine() {
        return oneWordPerTextLine;
    }


    public MarkingType getMarkingType() {
        return markingType;
    }


    public int getPlaceholdersCount() {
        return placeholdersCount;
    }


    public WritingStyle getWritingStyle() {
        return writingStyle;
    }


    public String getDescription() {
        return description;
    }


    public String getPdfPassword() {
        return pdfPassword;
    }


    public static class Builder {
        private String locationId;
        private String applicationId;
        private String password;
        private String proxyHost;
        private String proxyPort;
        private String proxyUsername;
        private String proxyPassword;
        private String trustAllRoots;
        private String x509HostnameVerifier;
        private String trustKeystore;
        private String trustPassword;
        private String connectTimeout;
        private String socketTimeout;
        private String keepAlive;
        private String connectionsMaxPerRoute;
        private String connectionsMaxTotal;
        private String responseCharacterSet;
        private String destinationFile;
        private String sourceFile;
        private String region;
        private String language;
        private String letterSet;
        private String regExp;
        private String textType;
        private String oneTextLine;
        private String oneWordPerTextLine;
        private String markingType;
        private String placeholdersCount;
        private String writingStyle;
        private String description;
        private String pdfPassword;


        public Builder locationId(String locationId) {
            this.locationId = locationId;
            return this;
        }


        public Builder applicationId(String applicationId) {
            this.applicationId = applicationId;
            return this;
        }


        public Builder password(String password) {
            this.password = password;
            return this;
        }


        public Builder proxyHost(String proxyHost) {
            this.proxyHost = proxyHost;
            return this;
        }


        public Builder proxyPort(String proxyPort) {
            this.proxyPort = proxyPort;
            return this;
        }


        public Builder proxyUsername(String proxyUsername) {
            this.proxyUsername = proxyUsername;
            return this;
        }


        public Builder proxyPassword(String proxyPassword) {
            this.proxyPassword = proxyPassword;
            return this;
        }


        public Builder trustAllRoots(String trustAllRoots) {
            this.trustAllRoots = trustAllRoots;
            return this;
        }


        public Builder x509HostnameVerifier(String x509HostnameVerifier) {
            this.x509HostnameVerifier = x509HostnameVerifier;
            return this;
        }


        public Builder trustKeystore(String trustKeystore) {
            this.trustKeystore = trustKeystore;
            return this;
        }


        public Builder trustPassword(String trustPassword) {
            this.trustPassword = trustPassword;
            return this;
        }


        public Builder connectTimeout(String connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;
        }


        public Builder socketTimeout(String socketTimeout) {
            this.socketTimeout = socketTimeout;
            return this;
        }


        public Builder keepAlive(String keepAlive) {
            this.keepAlive = keepAlive;
            return this;
        }


        public Builder connectionsMaxPerRoute(String connectionsMaxPerRoute) {
            this.connectionsMaxPerRoute = connectionsMaxPerRoute;
            return this;
        }


        public Builder connectionsMaxTotal(String connectionsMaxTotal) {
            this.connectionsMaxTotal = connectionsMaxTotal;
            return this;
        }


        public Builder responseCharacterSet(String responseCharacterSet) {
            this.responseCharacterSet = responseCharacterSet;
            return this;
        }


        public Builder destinationFile(String destinationFile) {
            this.destinationFile = destinationFile;
            return this;
        }


        public Builder sourceFile(String sourceFile) {
            this.sourceFile = sourceFile;
            return this;
        }


        public Builder region(String region) {
            this.region = region;
            return this;
        }


        public Builder language(String language) {
            this.language = language;
            return this;
        }


        public Builder letterSet(String letterSet) {
            this.letterSet = letterSet;
            return this;
        }


        public Builder regExp(String regExp) {
            this.regExp = regExp;
            return this;
        }


        public Builder textType(String textType) {
            this.textType = textType;
            return this;
        }


        public Builder oneTextLine(String oneTextLine) {
            this.oneTextLine = oneTextLine;
            return this;
        }


        public Builder oneWordPerTextLine(String oneWordPerTextLine) {
            this.oneWordPerTextLine = oneWordPerTextLine;
            return this;
        }


        public Builder markingType(String markingType) {
            this.markingType = markingType;
            return this;
        }


        public Builder placeholdersCount(String placeholdersCount) {
            this.placeholdersCount = placeholdersCount;
            return this;
        }


        public Builder writingStyle(String writingStyle) {
            this.writingStyle = writingStyle;
            return this;
        }


        public Builder description(String description) {
            this.description = description;
            return this;
        }


        public Builder pdfPassword(String pdfPassword) {
            this.pdfPassword = pdfPassword;
            return this;
        }


        public ProcessTextFieldInput build() throws Exception {

            ProcessTextFieldInput input = new ProcessTextFieldInput();

            input.locationId = InputParser.parseEnum(this.locationId, LocationId.class, InputNames.LOCATION_ID);

            input.applicationId = this.applicationId;

            input.password = this.password;

            input.proxyHost = this.proxyHost;

            input.proxyPort = InputParser.parseProxyPort(this.proxyPort);

            input.proxyUsername = this.proxyUsername;

            input.proxyPassword = this.proxyPassword;

            input.trustAllRoots = InputParser.parseBoolean(this.trustAllRoots, HttpClientInputs.TRUST_ALL_ROOTS);

            input.x509HostnameVerifier = this.x509HostnameVerifier;

            input.trustKeystore = this.trustKeystore;

            input.trustPassword = this.trustPassword;

            input.connectTimeout = InputParser.parseNonNegativeInt(this.connectTimeout, HttpClientInputs.CONNECT_TIMEOUT);

            input.socketTimeout = InputParser.parseNonNegativeInt(this.socketTimeout, HttpClientInputs.SOCKET_TIMEOUT);

            input.keepAlive = InputParser.parseBoolean(this.keepAlive, HttpClientInputs.KEEP_ALIVE);

            input.connectionsMaxPerRoute = InputParser.parseNonNegativeInt(this.connectionsMaxPerRoute, HttpClientInputs.CONNECTIONS_MAX_PER_ROUTE);

            input.connectionsMaxTotal = InputParser.parseNonNegativeInt(this.connectionsMaxTotal, HttpClientInputs.CONNECTIONS_MAX_TOTAL);

            input.responseCharacterSet = this.responseCharacterSet;

            if(StringUtils.isNotEmpty(this.destinationFile)) {
                input.destinationFile = new File(this.destinationFile);
            }

            input.sourceFile = new File(this.sourceFile);

            input.region = InputParser.parseRegion(this.region);

            String[] languages = this.language.split("[,]");
            input.languages = Arrays.asList(languages);

            input.letterSet = this.letterSet;

            input.regExp = this.regExp;

            input.textType = InputParser.parseEnum(this.textType, TextType.class, InputNames.TEXT_TYPE);

            input.oneTextLine = InputParser.parseBoolean(this.oneTextLine, InputNames.ONE_TEXT_LINE);

            input.oneWordPerTextLine = InputParser.parseBoolean(this.oneWordPerTextLine, InputNames.ONE_WORD_PER_TEXT_LINE);

            input.markingType = InputParser.parseEnum(this.markingType, MarkingType.class, InputNames.MARKING_TYPE);

            input.placeholdersCount = InputParser.parseNonNegativeInt(this.placeholdersCount, InputNames.PLACEHOLDERS_COUNT);

            input.writingStyle = InputParser.parseEnum(this.writingStyle, WritingStyle.class, InputNames.WRITING_STYLE);

            input.description = InputParser.parseDescription(this.description);

            input.pdfPassword = StringUtils.defaultString(this.pdfPassword);

            return input;
        }
    }
}