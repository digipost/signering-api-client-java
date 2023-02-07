package no.digipost.signature.client;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public enum Certificates {

    TEST(
            "test/Buypass_Class_3_Test4_CA_3.cer",
            "test/Buypass_Class_3_Test4_Root_CA.cer",

            "test/BPCl3CaG2HTBS.cer",
            "test/BPCl3CaG2STBS.cer",
            "test/BPCl3RootCaG2HT.cer",
            "test/BPCl3RootCaG2ST.cer",

            "test/commfides_test_ca.cer",
            "test/commfides_test_root_ca.cer",

            "test/digipost_test_root_ca.cert.pem"

    ),
    PRODUCTION(
            "prod/BPClass3CA3.cer",
            "prod/BPClass3RootCA.cer",

            "prod/BPCl3CaG2HTBS.cer",
            "prod/BPCl3CaG2STBS.cer",
            "prod/BPCl3RootCaG2HT.cer",
            "prod/BPCl3RootCaG2ST.cer",

            "prod/commfides_ca.cer",
            "prod/commfides_root_ca.cer"
    );

    public final List<String> certificatePaths;

    Certificates(String ... certificatePaths) {
        this.certificatePaths = Stream.of(certificatePaths)
                .map("classpath:/certificates/"::concat)
                .collect(toList());
    }

}
