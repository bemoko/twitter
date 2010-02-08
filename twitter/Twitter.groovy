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
 * Plugin to interface with twitter XML apis
 */

package twitter

import java.util.Map;

import javax.xml.soap.Text;
import javax.xml.transform.Source;

import com.bemoko.live.platform.mwc.plugins.AbstractPlugin
import twitter.domain.*

class Twitter extends AbstractPlugin {
    
    def searchApiUrl='http://search.twitter.com'
    def statusApiUrl='http://twitter.com/statuses'
    
    private def defaultUserId
    
    void initialise(Map parameters) {
        defaultUserId=parameters?.defaultUserId
    }
    
    List userTimeline(def count, String id=defaultUserId, int page=1) {
        def twitterResponse
        try{
            def apiUrl="${statusApiUrl}/user_timeline.xml?id=${id}&count=${count}&page=${page}"
            twitterResponse = new XmlSlurper(false,false).parse(apiUrl)
        }catch(Exception ex){
            // a failure could be caused by a fragile remote service
            // treat as a temporarily unavailable situation
            
            // to debug failures uncomment the line below
            //ex.printStackTrace()
            return []
        }
        List statuses=[]
        twitterResponse.status.each {
            statuses+=new Status(
            createdAt : it.created_at,
            id : it.id,
            text : it.text,
            source : it.source,
            truncated : it.truncated.toBoolean(),
            inReplyToStatusId : it.in_reply_to_status_id,
            inReplyToUserId : it.in_reply_to_user_id,
            favorited : it.favorited.toBoolean(),
            inReplyToScreenName : it.in_reply_to_screen_name,
            geo : it.geo.text,
            user : new User (
	            id : it.user.id,
	            name : it.user.name,
	            screenName : it.user.screen_name,
	            location : it.user.location,
	            description : it.user.description,
	            profileImageUrl : it.user.profile_image_url,
	            url : it.user.url,
	            isProtected : it.user.protected,
	            followersCount: it.user.followers_count,
	            profileBackgroundColor : it.user.profile_background_color,
	            profileTextColor : it.user.profile_text_color,
	            profileLinkColor : it.user.profile_link_color,
	            profileSidebarFillColor : it.user.profile_sidebar_fill_color,
	            profileSidebarBorderColor : it.user.profile_sidebar_border_color,
	            friendsCount : it.user.friends_count,
	            createdAt : it.user.created_at,
	            favouritesCount : it.user.favourites_count,
	            utcOffset : it.user.utc_offset,
	            timezone : it.user.time_zone,
	            profileBackgroundImageUrl : it.user.profile_background_image_url,
	            profileBackgroundTile : it.user.profile_background_tile.asBoolean(),
	            notifications : it.user.notifications.asBoolean(),
	            geoEnabled : it.user.geo_enabled.asBoolean(),
	            verified : it.user.verified.asBoolean(),
	            following : it.user.following.asBoolean(),
	            statusesCount : it.user.statuses_count,
	            lang : it.user.lang,
                contributorsEnabled : it.user.contributors_enabled.asBoolean()
	            )
            )
        }
        return statuses
    }
}
