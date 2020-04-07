/*
 * (c) Copyright 2019 EntIT Software LLC, a Micro Focus company, L.P.
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
package io.cloudslang.content.abby.entities;

import io.cloudslang.content.abby.constants.ExceptionMsgs;

public enum Profile {
    DOCUMENT_CONVERSION("documentConversion"),
    DOCUMENT_ARCHIVING("documentArchiving"),
    TEXT_EXTRACTION("textExtraction"),
    BARCODE_RECOGNITION("barcodeRecognition");

    private final String str;


    Profile(String str) {
        this.str = str;
    }


    public static Profile fromString(String str) throws Exception {
        for (Profile p : Profile.values()) {
            if (p.str.equals(str)) {
                return p;
            }
        }
        throw new IllegalArgumentException(String.format(ExceptionMsgs.INVALID_PROFILE, str));
    }


    @Override
    public String toString() {
        return this.str;
    }
}
