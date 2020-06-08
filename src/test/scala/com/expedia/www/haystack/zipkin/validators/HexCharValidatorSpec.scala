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

package com.expedia.www.haystack.zipkin.validators

import unit.UnitTestSpec

class HexCharValidatorSpec extends UnitTestSpec {

  "HexCharValidator for 128 bit" should {
    "validate a 128 bit valid hex char id" in {

      Given("a string of 128 bit hex char value")
      val hexCharID = "fee92dfd87cb430fa30922dc540270b5"

      When("HexChar validator is called")
      val isValidHexChar = HexCharValidator.isValid128BitHexChar(hexCharID)

      Then("true should be returned")
      isValidHexChar should equal(true)
    }

    "not validate a 128 bit non hex char id" in {

      Given("an invalid string of 128 bit non hex char value")
      val hexCharID = "See92dfd87cb430fa30922dc540270b5"

      When("HexChar validator is called")
      val isValidHexChar = HexCharValidator.isValid128BitHexChar(hexCharID)

      Then("false should be returned")
      isValidHexChar should equal(false)
    }

    "not validate an invalid length 128 bit valid hex char id" in {

      Given("an invalid string of 128 bit non hex char value")
      val hexCharID = "afee92dfd87cb430fa30922dc540270b5"

      When("HexChar validator is called")
      val isValidHexChar = HexCharValidator.isValid128BitHexChar(hexCharID)

      Then("false should be returned")
      isValidHexChar should equal(false)
    }
  }

  "HexCharValidator for 64 bit" should {
    "validate a 64 bit valid hex char id" in {

      Given("a string of 64 bit hex char value")
      val hexCharID = "fee92dfd87cb4301"

      When("HexChar validator is called")
      val isValidHexChar = HexCharValidator.isValid64BitHexChar(hexCharID)

      Then("true should be returned")
      isValidHexChar should equal(true)
    }

    "not validate a 64 bit non hex char id" in {

      Given("an invalid string of 64 bit non hex char value")
      val hexCharID = "See92dfd87cb4301"

      When("HexChar validator is called")
      val isValidHexChar = HexCharValidator.isValid64BitHexChar(hexCharID)

      Then("false should be returned")
      isValidHexChar should equal(false)
    }

    "not validate an invalid length 64 bit valid hex char id" in {

      Given("an invalid string of 64 bit non hex char value")
      val hexCharID = "fee92dfd87cb43012"

      When("HexChar validator is called")
      val isValidHexChar = HexCharValidator.isValid64BitHexChar(hexCharID)

      Then("false should be returned")
      isValidHexChar should equal(false)
    }
  }
}
