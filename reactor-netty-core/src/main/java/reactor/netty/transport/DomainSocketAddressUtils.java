/*
 * Copyright (c) 2024 VMware, Inc. or its affiliates, All Rights Reserved.
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
package reactor.netty.transport;

import io.netty.channel.unix.DomainSocketAddress;

import java.net.SocketAddress;

/**
 * Internal utility class for UDS on Java 8.
 *
 * @author Violeta Georgieva
 * @since 1.2.0
 */
public final class DomainSocketAddressUtils {

	/**
	 * Returns whether the {@code SocketAddress} is {@code DomainSocketAddress}.
	 *
	 * @param socketAddress the {@code SocketAddress} to test
	 * @return whether the {@code SocketAddress} is {@code DomainSocketAddress}
	 */
	public static boolean isDomainSocketAddress(SocketAddress socketAddress) {
		return socketAddress instanceof DomainSocketAddress;
	}

	/**
	 * Returns the path to the domain socket.
	 *
	 * @param socketAddress the {@code SocketAddress} to test
	 * @return the path to the domain socket
	 */
	public static String path(SocketAddress socketAddress) {
		if (isDomainSocketAddress(socketAddress)) {
			return ((DomainSocketAddress) socketAddress).path();
		}
		throw new IllegalArgumentException(socketAddress + " not supported");
	}

	private DomainSocketAddressUtils() {
	}
}
