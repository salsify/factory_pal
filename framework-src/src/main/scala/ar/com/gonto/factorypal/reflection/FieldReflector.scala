/*
 * *
 *  * Copyright 2012 Martin Gontovnikas (martin at gonto dot com dot ar) - twitter: @mgonto
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  *
 *
 */

package ar.com.gonto.factorypal.reflection

/**
 * This class is a helper to set and get values of a certain field property by reflection
 * @author mgonto
 */
class FieldReflector[O](ref: O) {
  def getV(name: String): Any =
    getField(name).get(ref)


  def setV[T](name: String, value: T) {
    getField(name).set(ref, value)
  }

  private def getField(name : String) = {
    val field = ref.getClass.getDeclaredField(name)
    field.setAccessible(true)
    field
  }


}
