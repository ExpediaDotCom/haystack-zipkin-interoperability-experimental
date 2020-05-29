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

import java.util.UUID

import unit.UnitTestSpec


class UUIDTransformerSpec extends UnitTestSpec {

  "UUID Transformer" should {
    "transform a given UUID to 128 bit hex char value" in {

      Given("a UUID value")
      val uuid  = UUID.fromString("fee92dfd-87cb-430f-a309-22dc540270b5")

      When("UUID Transformer is called")
      val hexChar = UUIDTransformer.uuidTo128BitHexCharEncoding(uuid)

      Then("equivalent valid hex char id is returned")
      hexChar.length should equal(32)
      uuid.toString should equal(HexCharTransformer.hexCharToUUID(hexChar).toString)

    }

    "transform a given UUID to 64 bit hex char value" in {

      Given("a UUID value")
      val uuid  = UUID.fromString("fee92dfd-87cb-430f-a309-22dc540270b5")


      When("UUID Transformer is called")
      val hexChar = UUIDTransformer.uuidTo64BitHexCharEncoding(uuid)

      Then("equivalent valid hex char id is returned")
      hexChar.length should equal(16)
      hexChar should equal(uuid.getLeastSignificantBits.toHexString)

    }

    "transform a given string UUID value to 128 bit hex char value " in {

      Given("a UUID value")
      val uuid = "fee92dfd-87cb-430f-a309-22dc540270b5"

      When("UUID Transformer is called")
      val hexChar = UUIDTransformer.uuidTo128BitHexCharEncoding(uuid)

      Then("equivalent valid hex char id is returned")
      hexChar.length should equal(32)
      uuid.toString should equal(HexCharTransformer.hexCharToUUID(hexChar).toString)

    }

    "transform a given string UUID value to 64 bit hex char value " in {

      Given("a UUID value")
      val uuid = "fee92dfd-87cb-430f-a309-22dc540270b5"

      When("UUID Transformer is called")
      val hexChar = UUIDTransformer.uuidTo64BitHexCharEncoding(uuid)

      Then("equivalent valid hex char id is returned")
      hexChar.length should equal(16)
      hexChar should equal("a30922dc540270b5")


    }

    "throw an illegal argument exception in case of invalid string uuid value for converting to 64 bit hex char value " in {

      Given("an invalid UUID value")
      val uuid = "zze92dfd-87cb-430z-a309-22dc540270b5"

      When("UUID Transformer is called, an exception is thrown")
      assertThrows[IllegalArgumentException] {
       UUIDTransformer.uuidTo64BitHexCharEncoding(uuid)
      }

    }


    "throw an illegal argument exception in case of invalid string uuid value for converting to 128 bit hex char value " in {

      Given("an invalid UUID value")
      val uuid = "zze92dfd-87cb-430z-a309-22dc540270b5"

      When("UUID Transformer is called, an exception is thrown")
      assertThrows[IllegalArgumentException] {
        UUIDTransformer.uuidTo128BitHexCharEncoding(uuid)
      }

    }




  }
}
