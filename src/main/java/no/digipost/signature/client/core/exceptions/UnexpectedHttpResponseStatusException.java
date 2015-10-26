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
package no.digipost.signature.client.core.exceptions;

import javax.ws.rs.core.Response.Status;

public class UnexpectedHttpResponseStatusException extends SignatureException {

    public UnexpectedHttpResponseStatusException(Status actual, Status... expected) {
        super("expected one of " + new ExpectedStatuses(expected) +
              ", but got " + actual.getStatusCode() + " " + actual.getReasonPhrase());
    }

    private static class ExpectedStatuses {
        private Status[] statuses;

        public ExpectedStatuses(Status... statuses) {
            this.statuses = statuses;
        }

        @Override
        public String toString() {
            String message = "";
            for (Status status : statuses) {
                message += status.getStatusCode() + " " + status.getReasonPhrase() + ", ";
            }
            return message;
        }
    }

}
