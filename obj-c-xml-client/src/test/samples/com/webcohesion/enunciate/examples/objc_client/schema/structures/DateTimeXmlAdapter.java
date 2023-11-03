/**
 * Copyright © 2006-2016 Web Cohesion (info@webcohesion.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.webcohesion.enunciate.examples.objc_client.schema.structures;

import com.webcohesion.enunciate.metadata.Ignore;
import org.joda.time.DateTime;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.util.Date;

/**
 * @author Ryan Heaton
 */
@Ignore
public class DateTimeXmlAdapter extends XmlAdapter<Date, DateTime> {

  public DateTime unmarshal(Date date) throws Exception {
    return new DateTime(date);
  }

  public Date marshal(DateTime dateTime) throws Exception {
    return dateTime.toDate();
  }
}
