/*
 * Copyright 2020 Expedia Group.
 *
 *        Licensed under the Apache License, Version 2.0 (the "License");
 *        you may not use this file except in compliance with the License.
 *        You may obtain a copy of the License at
 *
 *            http://www.apache.org/licenses/LICENSE-2.0
 *
 *        Unless required by applicable law or agreed to in writing, software
 *        distributed under the License is distributed on an "AS IS" BASIS,
 *        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *        See the License for the specific language governing permissions and
 *        limitations under the License.
 */


package com.expedia.www.haystack.zipkin.transformers

import unit.UnitTestSpec

class HexCharTransformerSpec extends UnitTestSpec {

  "HexChar Transformer  " should {
    "128 bit valid hex char id to UUID" in {

      Given("128 bit value hex char id")
      val hexCharID = "fee92dfd87cb430fa30922dc540270b5"

      When("HexChar Transformer is called to convert to UUID")
      val uuid = HexCharTransformer.hexCharToUUID(hexCharID)

      Then("valid uuid is received")
      hexCharID should equal(UUIDTransformer.uuidTo128BitHexCharEncoding(uuid))
    }


    "64 bit valid hex char id to UUID" in {

      Given("64 bit value hex char id")
      val hexCharID = "fee92dfd87cb430f"

      When("HexChar Transformer is called to convert to UUID")
      val uuid = HexCharTransformer.hexCharToUUID(hexCharID)

      Then("valid uuid is received")
      hexCharID should equal(UUIDTransformer.uuidTo64BitHexCharEncoding(uuid))

    }

    "throw a NumberFormat Exception incase of invalid 128 bit hex char id" in {

      Given("128 bit invalid hex char id")
      val hexCharID = "zee92dfz87cb430fa30922dc540270b5"

      When("HexChar Transformer is called to convert to UUID, an exception is thrown")
      assertThrows[NumberFormatException] {
        HexCharTransformer.hexCharToUUID(hexCharID)
      }

    }


    "throw a NumberFormat Exception incase of invalid 64 bit hex char id" in {

      Given("64 bit invalid hex char id")
      val hexCharID = "zye92dfd87cb430f"

      When("HexChar Transformer is called to convert to UUID, an exception is thrown")
      assertThrows[NumberFormatException] {
        HexCharTransformer.hexCharToUUID(hexCharID)
      }


    }

    "throw an Illegal Argument Exception incase of hex char id of length other than 64/128 bit " in {
      Given("A hex char id with invalid length")
      val hexCharID = "aee92dfd87cb430f2345"

      When("HexChar Transformer is called to convert to UUID, an exception is thrown")
      assertThrows[IllegalArgumentException] {
        HexCharTransformer.hexCharToUUID(hexCharID)
      }

    }

  }

}
