/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Copyright @2010 bemoko 
 */

package twitter.domain

import java.text.SimpleDateFormat

class Status {
    
    private def DATE_FORMAT = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy")
    
	String createdAt
    Date getCreatedAt() {
		if(createdAt) return DATE_FORMAT.parse(createdAt)
    }
	def id
	def text
    def source
    def truncated
    def inReplyToStatusId
    def inReplyToUserId
    def favorited
    def inReplyToScreenName
    User user
    def geo
    def contributors=[] //list of user ids
}
