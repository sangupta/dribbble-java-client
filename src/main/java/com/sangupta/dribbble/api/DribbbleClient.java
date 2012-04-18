/**
 *
 * dribbble-java-client: Java Client for Dribbble.com API
 * Copyright (c) 2012, Sandeep Gupta
 * 
 * http://www.sangupta/projects/dribbble-java-client
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.dribbble.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sangupta.dribbble.api.model.CommentList;
import com.sangupta.dribbble.api.model.Player;
import com.sangupta.dribbble.api.model.PlayerList;
import com.sangupta.dribbble.api.model.Shot;
import com.sangupta.dribbble.api.model.ShotList;
import com.sangupta.dribbble.api.model.ShotListType;

/**
 * Client to access Dribbble APIs from Java. The client supports all available
 * methods in the Dribbble API and provide results as strongly-typed Java objects.
 * All return objects implement the {@link Comparable} interface for comparison
 * and also implement the <code>equals</code> and <code>hashCode</code> methods
 * for convenient use by business code.
 * 
 * The client also implements rate limiting guidelines as per the Dribbble API
 * documentation of 60 requests per minute. Also exposed is a convenience class
 * called {@link DribbbleInvoker} that may be used to add more APIs (should they
 * get added in future and this library looses track). The invoker is rate-limit
 * safe.
 * 
 * @author sangupta
 *
 */
public class DribbbleClient {
	
	/**
	 * Internal final reference to Google GSON library for unmarshalling responses.
	 */
	private static final Gson GSON = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
	
	/**
	 * Keeps track whether to throw a runtime exception, {@link DribbbleApiRateLimitException}, when
	 * the hit-rate goes over board.
	 */
	private boolean throwException = true;
	
	private static final int DEFAULT_PAGE = 1;
	
	private static final int DEFAULT_PER_PAGE = 15;
	
	/**
	 * Create a new client for Dribbble.
	 * 
	 */
	public DribbbleClient() {
		// do nothing for now
		// there is no provision for picking API keys :)
	}
	
	/**
	 * Convenience constructor that also sets whether we need to throw
	 * rate limiting exception, {@link DribbbleApiRateLimitException} or not.
	 * 
	 * @param throwException
	 */
	public DribbbleClient(boolean throwException) {
		this.throwException = throwException;
	}
	
	/**
	 * Returns details for a shot specified by :id.
	 * 
	 * @param shotID
	 * @return
	 */
	public Shot getShot(long shotID) {
		if(shotID < 1) {
			throw new IllegalArgumentException("Shot ID must be greater than zero.");
		}
		
		return response("shots/" + String.valueOf(shotID), Shot.class);
	}
	
	/**
	 * Returns the set of rebounds (shots in response to a shot) for the shot specified by :id.
	 * 
	 * @param shotID
	 * @return
	 */
	public ShotList getShotRebounds(long shotID) {
		return getShotRebounds(shotID, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the set of rebounds (shots in response to a shot) for the shot specified by :id.
	 * 
	 * @param shotID
	 * @param page
	 * @param perPage
	 * @return
	 */
	public ShotList getShotRebounds(long shotID, int page, int perPage) {
		if(shotID < 1) {
			throw new IllegalArgumentException("Shot ID must be greater than zero.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("shots/" + String.valueOf(shotID) + "/rebounds", ShotList.class, page, perPage);
	}
	
	/**
	 * Returns the set of comments for the shot specified by :id.
	 * 
	 * @param shotID
	 * @return
	 */
	public CommentList getShotComments(long shotID) {
		return getShotComments(shotID, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the set of comments for the shot specified by :id.
	 * 
	 * @param shotID
	 * @param page
	 * @param perPage
	 * @return
	 */
	public CommentList getShotComments(long shotID, int page, int perPage) {
		if(shotID < 1) {
			throw new IllegalArgumentException("Shot ID must be greater than zero.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("shots/" + String.valueOf(shotID) + "/comments", CommentList.class, page, perPage);
	}
	
	/**
	 * Returns the specified list of shots where :list has one of the following values: debuts, everyone, popular
	 * 
	 * @param type
	 * @return
	 */
	public ShotList getShotsList(ShotListType shotListType) {
		return getShotsList(shotListType, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the specified list of shots where :list has one of the following values: debuts, everyone, popular
	 * 
	 * @param shotListType
	 * @param page
	 * @param perPage
	 * @return
	 */
	public ShotList getShotsList(ShotListType shotListType, int page, int perPage) {
		if(shotListType == null) {
			throw new IllegalArgumentException("Shot type cannot be null.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("shots/" + shotListType.toString().toLowerCase(), ShotList.class, page, perPage);
	}
	
	/**
	 * Returns the most recent shots for the player specified by :id.
	 * 
	 * @param playerID
	 * @return
	 */
	public ShotList getShotsForPlayer(long playerID) {
		return getShotsForPlayer(playerID, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the most recent shots for the player specified by :id.
	 * 
	 * @param playerID
	 * @param page
	 * @param perPage
	 * @return
	 */
	public ShotList getShotsForPlayer(long playerID, int page, int perPage) {
		if(playerID < 1) {
			throw new IllegalArgumentException("Player ID must be greater than ZERO.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + String.valueOf(playerID) + "/shots", ShotList.class, page, perPage);
	}
	
	/**
	 * Returns the most recent shots for the player specified by :id.
	 * 
	 * @param playerUsername
	 * @return
	 */
	public ShotList getShotsForPlayer(String playerUsername) {
		return getShotsForPlayer(playerUsername, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the most recent shots for the player specified by :id.
	 * 
	 * @param playerUsername
	 * @param page
	 * @param perPage
	 * @return
	 */
	public ShotList getShotsForPlayer(String playerUsername, int page, int perPage) {
		if(playerUsername == null || playerUsername.trim().length() == 0) {
			throw new IllegalArgumentException("Player username cannot be null/empty.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + playerUsername + "/shots", ShotList.class, page, perPage);
	}
	
	/**
	 * Returns the most recent shots published by those the player specified by :id is following.
	 * 
	 * @param playerID
	 * @return
	 */
	public ShotList getShotsOfPlayerFollowed(long playerID) {
		return getShotsOfPlayerFollowed(playerID, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the most recent shots published by those the player specified by :id is following.
	 * 
	 * @param playerID
	 * @param page
	 * @param perPage
	 * @return
	 */
	public ShotList getShotsOfPlayerFollowed(long playerID, int page, int perPage) {
		if(playerID < 1) {
			throw new IllegalArgumentException("Player ID must be greater than ZERO.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + String.valueOf(playerID) + "/shots/following", ShotList.class, page, perPage);
	}
	
	/**
	 * Returns the most recent shots published by those the player specified by :id is following.
	 * 
	 * @param playerID
	 * @return
	 */
	public ShotList getShotsOfPlayerFollowed(String playerUsername) {
		return getShotsOfPlayerFollowed(playerUsername, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the most recent shots published by those the player specified by :id is following.
	 * 
	 * @param playerUsername
	 * @param page
	 * @param perPage
	 * @return
	 */
	public ShotList getShotsOfPlayerFollowed(String playerUsername, int page, int perPage) {
		if(playerUsername == null || playerUsername.trim().length() == 0) {
			throw new IllegalArgumentException("Player username cannot be null/empty.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + playerUsername + "/shots/following", ShotList.class, page, perPage);
	}
	
	/**
	 * Returns shots liked by the player specified by :id.
	 * 
	 * @param playerID
	 * @return
	 */
	public ShotList getPlayerLikedShots(long playerID) {
		return getPlayerLikedShots(playerID, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns shots liked by the player specified by :id.
	 * 
	 * @param playerID
	 * @param page
	 * @param perPage
	 * @return
	 */
	public ShotList getPlayerLikedShots(long playerID, int page, int perPage) {
		if(playerID < 1) {
			throw new IllegalArgumentException("Player ID must be greater than ZERO.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + String.valueOf(playerID) + "/shots/likes", ShotList.class, page, perPage);
	}
	
	/**
	 * Returns shots liked by the player specified by :id.
	 * 
	 * @param playerID
	 * @return
	 */
	public ShotList getPlayerLikedShots(String playerUsername) {
		return getPlayerLikedShots(playerUsername, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns shots liked by the player specified by :id.
	 * 
	 * @param playerUsername
	 * @param page
	 * @param perPage
	 * @return
	 */
	public ShotList getPlayerLikedShots(String playerUsername, int page, int perPage) {
		if(playerUsername == null || playerUsername.trim().length() == 0) {
			throw new IllegalArgumentException("Player username cannot be null/empty.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + playerUsername + "/shots/likes", ShotList.class, page, perPage);
	}
	
	/**
	 * Returns profile details for a player specified by :id.
	 * 
	 * @param playerID
	 * @return
	 */
	public Player getPlayer(long playerID) {
		if(playerID < 1) {
			throw new IllegalArgumentException("Player ID must be greater than ZERO.");
		}
		
		return response("players/" + String.valueOf(playerID), Player.class);
	}
	
	/**
	 * Returns profile details for a player specified by :id.
	 * 
	 * @param playerID
	 * @return
	 */
	public Player getPlayer(String playerUsername) {
		if(playerUsername == null || playerUsername.trim().length() == 0) {
			throw new IllegalArgumentException("Player username cannot be null/empty.");
		}
		
		return response("players/" + playerUsername, Player.class);
	}
	
	/**
	 * Returns the list of followers for a player specified by :id.
	 * 
	 * @param playerID
	 * @return
	 */
	public PlayerList getPlayerFollowers(long playerID) {
		return getPlayerFollowers(playerID, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the list of followers for a player specified by :id.
	 * 
	 * @param playerID
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PlayerList getPlayerFollowers(long playerID, int page, int perPage) {
		if(playerID < 1) {
			throw new IllegalArgumentException("Player ID must be greater than ZERO.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + String.valueOf(playerID) + "/followers", PlayerList.class, page, perPage);
	}
	
	/**
	 * Returns the list of followers for a player specified by :id.
	 * 
	 * @param playerUsername
	 * @return
	 */
	public PlayerList getPlayerFollowers(String playerUsername) {
		return getPlayerFollowers(playerUsername, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the list of followers for a player specified by :id.
	 * 
	 * @param playerUsername
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PlayerList getPlayerFollowers(String playerUsername, int page, int perPage) {
		if(playerUsername == null || playerUsername.trim().length() == 0) {
			throw new IllegalArgumentException("Player username cannot be null/empty.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + playerUsername + "/followers", PlayerList.class, page, perPage);
	}
	
	/**
	 * Returns the list of players followed by the player specified by :id.
	 * 
	 * @param playerID
	 * @return
	 */
	public PlayerList getPlayerFollowed(long playerID) {
		return getPlayerFollowed(playerID, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the list of players followed by the player specified by :id.
	 * 
	 * @param playerID
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PlayerList getPlayerFollowed(long playerID, int page, int perPage) {
		if(playerID < 1) {
			throw new IllegalArgumentException("Player ID must be greater than ZERO.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + String.valueOf(playerID) + "/following", PlayerList.class, page, perPage);
	}
	
	/**
	 * Returns the list of players followed by the player specified by :id.
	 * 
	 * @param playerUsername
	 * @return
	 */
	public PlayerList getPlayerFollowed(String playerUsername) {
		return getPlayerFollowed(playerUsername, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}

	/**
	 * Returns the list of players followed by the player specified by :id.
	 * 
	 * @param playerUsername
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PlayerList getPlayerFollowed(String playerUsername, int page, int perPage) {
		if(playerUsername == null || playerUsername.trim().length() == 0) {
			throw new IllegalArgumentException("Player username cannot be null/empty.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + playerUsername + "/following", PlayerList.class, page, perPage);
	}
	
	/**
	 * Returns the list of players drafted by the player specified by :id.
	 * 
	 * @param playerID
	 * @return
	 */
	public PlayerList getPlayerDraftees(long playerID) {
		return getPlayerDraftees(playerID, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the list of players drafted by the player specified by :id.
	 * 
	 * @param playerID
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PlayerList getPlayerDraftees(long playerID, int page, int perPage) {
		if(playerID < 1) {
			throw new IllegalArgumentException("Player ID must be greater than ZERO.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + String.valueOf(playerID) + "/draftees", PlayerList.class, page, perPage);
	}
	
	/**
	 * Returns the list of players drafted by the player specified by :id.
	 * 
	 * @param playerUsername
	 * @return
	 */
	public PlayerList getPlayerDraftees(String playerUsername) {
		return getPlayerDraftees(playerUsername, DEFAULT_PAGE, DEFAULT_PER_PAGE);
	}
	
	/**
	 * Returns the list of players drafted by the player specified by :id.
	 * 
	 * @param playerUsername
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PlayerList getPlayerDraftees(String playerUsername, int page, int perPage) {
		if(playerUsername == null || playerUsername.trim().length() == 0) {
			throw new IllegalArgumentException("Player username cannot be null/empty.");
		}
		
		if(page < 1) {
			throw new IllegalArgumentException("Page number must be greater than zero.");
		}
		
		if(perPage < 1) {
			throw new IllegalArgumentException("Per-page number must be greater than zero.");
		}
		
		return response("players/" + playerUsername + "/draftees", PlayerList.class, page, perPage);
	}
	
	//---------------------------------------------------
	// Utility methods start
	//---------------------------------------------------
	
	/**
	 * Utility method to hit a given end point and return the results back.
	 * 
	 * @param endPoint the end point to hit in Dribbble
	 * @param clazz to cast result object to
	 * @return
	 */
	private <T> T response(String endPoint, Class<T> clazz) {
		String response = DribbbleInvoker.invokeEndPoint(endPoint, null, throwException);
		if(response != null) {
			return GSON.fromJson(response, clazz);
		}
		
		return null;
	}
	
	/**
	 * Utility method to hit a given end point and return the results back.
	 * 
	 * @param endPoint the end point to hit in Dribbble
	 * @param clazz to cast result object to
	 * @param page fetch given page of paginated API
	 * @param perPage fetch these many results for this page
	 * @return
	 */
	private <T> T response(String endPoint, Class<T> clazz, int page, int perPage) {
		StringBuilder builder = new StringBuilder();
		builder.append("page=");
		builder.append(page);
		builder.append("&per_page=");
		builder.append(perPage);
		
		String response = DribbbleInvoker.invokeEndPoint(endPoint, builder.toString(), throwException);
		if(response != null) {
			return GSON.fromJson(response, clazz);
		}
		
		return null;
	}
	
}
