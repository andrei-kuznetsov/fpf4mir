package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class CloneUtils {
	public static <T extends ActivityRelatedFact> T cloneActivityRelatedFact(
			T src, Activity newActivity) {
		T copy = org.apache.commons.lang3.SerializationUtils.clone(src);
		copy.setActivity(newActivity);
		return copy;
	}

	public static <T extends ActivityRelatedFactWithName> T cloneActivityRelatedFactWithName(
			T src, Activity newActivity, String newName) {
		T copy = org.apache.commons.lang3.SerializationUtils.clone(src);
		copy.setActivity(newActivity);
		copy.setName(newName);
		return copy;
	}
}
