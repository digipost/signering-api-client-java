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

import no.digipost.signature.client.core.ConfirmationReference;
import no.digipost.signature.client.core.PAdESReference;
import no.digipost.signature.client.core.XAdESReference;
import no.digipost.signature.client.core.internal.Confirmable;


public class DirectJobStatusResponse implements Confirmable {

    private final long signatureJobId;
    private final DirectJobStatus status;
    private final ConfirmationReference confirmationReference;
    private final XAdESReference xAdESReference;
    private final PAdESReference pAdESReference;

    public DirectJobStatusResponse(long signatureJobId, DirectJobStatus status, ConfirmationReference confirmationUrl, XAdESReference xAdESReference, PAdESReference pAdESReference) {
        this.signatureJobId = signatureJobId;
        this.status = status;
        this.confirmationReference = confirmationUrl;
        this.xAdESReference = xAdESReference;
        this.pAdESReference = pAdESReference;
    }

    public long getSignatureJobId() {
        return signatureJobId;
    }

    public DirectJobStatus getStatus() {
        return status;
    }

    public boolean is(DirectJobStatus status) {
        return this.status == status;
    }

    public XAdESReference getxAdESUrl() {
        return xAdESReference;
    }

    public boolean isPAdESAvailable() {
        return pAdESReference != null;
    }

    public PAdESReference getpAdESUrl() {
        return pAdESReference;
    }

    @Override
    public ConfirmationReference getConfirmationReference() {
        return confirmationReference;
    }

    @Override
    public String toString() {
        return "status for direct job with ID " + signatureJobId + ": " + status;
    }
}
