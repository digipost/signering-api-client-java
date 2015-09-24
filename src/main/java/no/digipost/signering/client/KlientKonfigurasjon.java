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
package no.digipost.signering.client;

import no.digipost.signering.client.internal.KeyStoreConfig;

import java.net.URI;

public class KlientKonfigurasjon {

    public KlientKonfigurasjon(URI signeringstjenesteRoot, KeyStoreConfig keyStoreConfig) {
        this.signeringstjenesteRoot = signeringstjenesteRoot;
        this.keyStoreConfig = keyStoreConfig;
    }

    private URI signeringstjenesteRoot;
    private KeyStoreConfig keyStoreConfig;

    public URI getSigneringstjenesteRoot() {
        return signeringstjenesteRoot;
    }

    public KeyStoreConfig getKeyStoreConfig() {
        return keyStoreConfig;
    }
}