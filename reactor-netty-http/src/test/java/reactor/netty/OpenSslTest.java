package reactor.netty;

import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.SslProvider;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenSslTest {
	@Test
	void testBoringSsl() {
		OpenSsl.ensureAvailability();
		assertTrue(OpenSsl.isAvailable());
		assertThat(OpenSsl.versionString()).isEqualTo("BoringSSL");
		assertTrue(SslProvider.isAlpnSupported(SslProvider.OPENSSL));
		assertTrue(SslProvider.isTlsv13Supported(SslProvider.OPENSSL));
	}
}
