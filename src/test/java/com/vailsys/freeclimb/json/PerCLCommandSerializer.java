package com.vailsys.freeclimb.json;

import java.lang.reflect.Type;

import com.vailsys.freeclimb.percl.PerCLCommand;
import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.reflect.TypeToken;

public class PerCLCommandSerializer implements JsonSerializer<PerCLCommand> {

	public JsonElement serialize(PerCLCommand src, Type typeOfSrc, JsonSerializationContext context) {
		JsonElement srcJsonElem = gson.toJsonTree(src);

		JsonObject obj = new JsonObject();
		obj.add(src.getClass().getSimpleName(), srcJsonElem);

		return obj;
	}
}
