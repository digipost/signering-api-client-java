/**
 * Copyright (C) Posten Norge AS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package no.digipost.signature.client.domain;

import no.digipost.signering.schema.v1.signature_job.XMLSignatureJobStatus;

public class SignatureJobStatusResponse {
    private SignatureJobStatus status;
    private XAdESReference xAdESUrl;
    private PAdESReference pAdESUrl;

    public SignatureJobStatusResponse(XMLSignatureJobStatus status, String xAdESUrl, String pAdESUrl) {
        this.status = SignatureJobStatus.fromXmlType(status);
        this.xAdESUrl = new XAdESReference(xAdESUrl);
        this.pAdESUrl = new PAdESReference(pAdESUrl);
    }

    public SignatureJobStatus getStatus() {
        return status;
    }

    public XAdESReference getxAdESUrl() {
        return xAdESUrl;
    }

    public PAdESReference getpAdESUrl() {
        return pAdESUrl;
    }
}