/*
 * Copyright (c) 2020-2024 VMware, Inc. or its affiliates, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package reactor.netty.examples.documentation.http.client.uds;

import io.netty.channel.unix.DomainSocketAddress;
import reactor.netty.http.client.HttpClient;

//import java.net.UnixDomainSocketAddress;

public class Application {

	public static void main(String[] args) {
		HttpClient client =
				HttpClient.create()
				          // The configuration below is available only when NIO transport is used with Java 17+
				          //.remoteAddress(() -> UnixDomainSocketAddress.of("/tmp/test.sock"));
				          // The configuration below is available only when Epoll/KQueue transport is used
				          .remoteAddress(() -> new DomainSocketAddress("/tmp/test.sock")); //<1>

		client.get()
		      .uri("/")
		      .response()
		      .block();
	}
}