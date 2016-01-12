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
package no.digipost.signature.client.direct;

import no.digipost.signature.client.core.Document;
import no.digipost.signature.client.core.Signer;

import java.util.UUID;

public class SignatureJob {

    private String reference;
    private Signer signer;
    private Document document;
    private String completionUrl;
    private String cancellationUrl;
    private String errorUrl;

    private SignatureJob(Signer signer, Document document, String completionUrl, String cancellationUrl, String errorUrl) {
        this.signer = signer;
        this.document = document;
        this.completionUrl = completionUrl;
        this.cancellationUrl = cancellationUrl;
        this.errorUrl = errorUrl;
    }

    public String getReference() {
        return reference;
    }

    public Signer getSigner() {
        return signer;
    }

    public Document getDocument() {
        return document;
    }

    public String getCompletionUrl() {
        return completionUrl;
    }

    public String getCancellationUrl() {
        return cancellationUrl;
    }

    public String getErrorUrl() {
        return errorUrl;
    }

    public static Builder builder(Signer signer, Document document, String completionUrl, String cancellationUrl, String errorUrl) {
        return new Builder(signer, document, completionUrl, cancellationUrl, errorUrl);
    }

    public static class Builder {

        private final SignatureJob target;
        private boolean built = false;

        public Builder(Signer signer, Document document, String completionUrl, String cancellationUrl, String errorUrl) {
            target = new SignatureJob(signer, document, completionUrl, cancellationUrl, errorUrl);
        }

        public Builder withReference(UUID uuid) {
            return withReference(uuid.toString());
        }

        public Builder withReference(String reference) {
            target.reference = reference;
            return this;
        }

        public SignatureJob build() {
            if (built) throw new IllegalStateException("Can't build twice");
            built = true;
            return target;
        }
    }

}
