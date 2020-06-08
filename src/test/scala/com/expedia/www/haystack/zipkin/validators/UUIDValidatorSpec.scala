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

class UUIDValidatorSpec extends UnitTestSpec {

  "UUIDValidator" should {
    "validate a 128 bit valid hex char id" in {

      Given("a string UUID value")
      val uuid = "fee92dfd-87cb-430f-a309-22dc540270b5"

      When("UUID validator is called")
      val isValid = UUIDValidator.isValidUUID(uuid)

      Then("true should be returned")
      isValid should equal(true)
    }

    "not validate an invalid UUID" in {

      Given("an invalid string of UUID")
      val uuid = "See92dfd-87cb-430f-a309-22dc540270b5"

      When("UUID validator is called")
      val isValid = UUIDValidator.isValidUUID(uuid)

      Then("false should be returned")
      isValid should equal(false)
    }

    "not validate an invalid length UUID" in {

      Given("an invalid string of 128 bit non hex char value")
      val uuid = "Afee92dfd-87cb-430f-a309-22dc540270b5"

      When("UUID validator is called")
      val isValid = UUIDValidator.isValidUUID(uuid)

      Then("false should be returned")
      isValid should equal(false)
    }
  }
}
