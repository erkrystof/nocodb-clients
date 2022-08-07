package io.krystof.nocodb.clients;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MyFinishedStatus {

	IN_PROGRESS("In Progress"), COMPLETED("Completed"), ABANDONED("Abandoned"), ON_HOLD("On Hold"),
	NOT_STARTED("Not Started");

	private static final Map<String, MyFinishedStatus> mMap = Collections.unmodifiableMap(initializeMapping());

	private String label;

	private MyFinishedStatus(String label) {
		this.label = label;
	}

	private static Map<String, MyFinishedStatus> initializeMapping() {
		Map<String, MyFinishedStatus> mMap = new HashMap<String, MyFinishedStatus>();
		for (MyFinishedStatus s : MyFinishedStatus.values()) {
			mMap.put(s.getLabel(), s);
		}
		return mMap;
	}

	public String getLabel() {
		return label;
	}

	@JsonCreator
	public static MyFinishedStatus forValue(String value) {
		return mMap.get(value);
	}

	@JsonValue
	public String toValue() {
		return this.getLabel();
	}

}
