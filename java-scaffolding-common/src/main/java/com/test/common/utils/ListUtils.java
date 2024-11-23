package com.test.common.utils;

import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

/**
 * List 共用方法
 */

public class ListUtils {
    private ListUtils() {
    }

    /**
     * Checks if the provided list is null and return an empty list if it is.
     * Otherwise, it returns the original list
     *
     * @param list provided list
     * @return List<T> empty list or original list
     */
    public static <T> List<T> emptyIfNull(final List<T> list) {
        return org.apache.commons.collections4.ListUtils.emptyIfNull(list);
    }

    /**
     * Return defaultList if provided list is null, otherwise return provided list
     *
     * @param list provided list
     * @param defaultList defaultList
     * @return List<T> provided list or defaultList
     */
    public static <T> List<T> defaultIfNull(final List<T> list, final List<T> defaultList) {
        return list == null ? defaultList : list;
    }

    /**
     * Union function to two list
     * returns a new list that contains the union of the two input lists
     *
     * @param list1 list1
     * @param list2 list2
     * @return List<T> elements from list1 and list2
     */
    public static <T> List<T> union(final List<T> list1, final List<T> list2) {
        if (ObjectUtils.isEmpty(list1) && ObjectUtils.isEmpty(list2)) {
            return null;
        } else if (ObjectUtils.isEmpty(list1) && !ObjectUtils.isEmpty(list2)) {
            return list2;
        } else if (ObjectUtils.isEmpty(list2) && !ObjectUtils.isEmpty(list1)) {
            return list1;
        }
        return org.apache.commons.collections4.ListUtils.union(list1, list2);
    }

    /**
     * The elements of the first list minus the elements of the second list, and return a new list
     *
     * @param list1 list1
     * @param list2 list2
     * @return List<T> elements of the first list minus the elements of the second list
     */
    public static <T> List<T> subtract(final List<T> list1, final List<T> list2) {
        if (ObjectUtils.isEmpty(list1) && ObjectUtils.isEmpty(list2)) {
            return null;
        } else if (ObjectUtils.isEmpty(list1) && !ObjectUtils.isEmpty(list2)) {
            return null;
        } else if (ObjectUtils.isEmpty(list2) && !ObjectUtils.isEmpty(list1)) {
            return list1;
        }
        return org.apache.commons.collections4.ListUtils.subtract(list1, list2);
    }

    /**
     * Returns a new list that contains the intersection of the two input lists
     * Intersection: Set of elements that are in both list1 and list2
     * @param list1 list1
     * @param list2 list2
     * @return List<T> elements that are in both list1 and list2
     */
    public static <T> List<T> intersection(final List<T> list1, final List<T> list2) {
        if (ObjectUtils.isEmpty(list1) || ObjectUtils.isEmpty(list2)) {
            return null;
        }
        return org.apache.commons.collections4.ListUtils.intersection(list1, list2);
    }

    /**
     * Returns a new list that contains the elements that are in both list1 and list2
     *
     * @param list1 list1
     * @param list2 list2
     * @return List<T> elements that are in both list1 and list2
     */
    public static <T> List<T> retainAll(final List<T> list1, final List<T> list2) {
        return org.apache.commons.collections4.ListUtils.retainAll(list1, list2);
    }

    public static <T> List<T> removeAll(final List<T> list1, final List<T> list2) {
        return org.apache.commons.collections4.ListUtils.removeAll(list1, list2);
    }

    /**
     * Returns a new list that contains the elements that are in list1 but not in list2
     *
     * @param list
     * @param predicate
     * @return
     * @param <T>
     */
    public static <T> List<T> select(final List<T> list, final org.apache.commons.collections4.Predicate<? super T> predicate) {
        return org.apache.commons.collections4.ListUtils.select(list, predicate);
    }

}
