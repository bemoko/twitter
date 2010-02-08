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

/*
 * Test implementation of atom feed processing against reference example available from http://www.atomenabled.org
 *
 * groovy twitter/tests/TwitterTest.groovy 
 */ 
package twitter.tests

import java.util.List;

import groovy.util.GroovyTestCase
import twitter.Twitter
import twitter.domain.Status

class TwitterTest extends GroovyTestCase{
    def twitter=new Twitter()
    
    void testUserTimeline() {
        //twitter.statusApiUrl="file:///"+new File(getClass().protectionDomain.codeSource.location.path).parent+"/"
        twitter.initialise(['defaultUserId':'bemoko'])
        def statuses= twitter.userTimeline(3)
        assertEquals ("status count in incorrect", 3, statuses.size())
        
        Status status1=statuses[0]
        assertNotNull ("created at not correct",status1.createdAt)
        assertNotNull ("id not correct",status1.id)
        assertNotNull ("text not correct",status1.text)
        assertNotNull ("source not correct",status1.source)
        assertNotNull ("truncated not correct",status1.truncated)
        assertNotNull ("in_reply_to_status_id not correct",status1.inReplyToStatusId)
        assertNotNull ("in_reply_to_user_id not correct",status1.inReplyToUserId)
        assertNotNull ("favorited not correct",status1.favorited)
        assertNotNull ("in_reply_to_screen_name not correct",status1.inReplyToScreenName)
        
        assertNotNull ("user is not correct",status1.user)
        assertNotNull ("user id is not correct",status1.user.id)
        assertNotNull ("user name is not correct",status1.user.name)
        assertNotNull ("user screenName is not correct",status1.user.screenName)
        assertNotNull ("user location is not correct", status1.user.location)
        assertNotNull ("user description is not correct", status1.user.description)
        assertNotNull ("user profileImageUrl is not correct", status1.user.profileImageUrl)
        assertNotNull ("user url is not correct", status1.user.url)
        assertNotNull ("user isProtected is not correct", status1.user.isProtected)
        assertNotNull ("user followersCount is not correct", status1.user.followersCount)
        assertNotNull ("user profileBackgroundColor is not correct", status1.user.profileBackgroundColor)
        assertNotNull ("user profileTextColor is not correct", status1.user.profileTextColor)
        assertNotNull ("user profileLinkColor is not correct", status1.user.profileLinkColor)
        assertNotNull ("user profileSidebarFillColor is not correct", status1.user.profileSidebarFillColor)
        assertNotNull ("user profileSidebarBorderColor is not correct", status1.user.profileSidebarBorderColor)
        assertNotNull ("user friendsCount is not correct", status1.user.friendsCount)
        assertNotNull ("user createdAt is not correct", status1.user.createdAt)
        assertNotNull ("user favouritesCount is not correct", status1.user.favouritesCount)
        assertNotNull ("user utcOffset is not correct", status1.user.utcOffset)
        assertNotNull ("user timezone is not correct", status1.user.timezone)
        assertNotNull ("user profileBackgroundImageUrl is not correct", status1.user.profileBackgroundImageUrl)
        assertNotNull ("user profileBackgroundTile is not correct", status1.user.profileBackgroundTile)
        assertNotNull ("user notifications is not correct", status1.user.notifications)
        assertNotNull ("user geoEnabled is not correct", status1.user.geoEnabled)
        assertNotNull ("user verified is not correct", status1.user.verified)
        assertNotNull ("user following is not correct", status1.user.following)
        assertNotNull ("user statusesCount is not correct", status1.user.statusesCount)
        assertNotNull ("user lang is not correct", status1.user.lang)
        assertNotNull ("user contributors enabledis not correct", status1.user.contributorsEnabled)
        
        
    }
}