/**
 *  Copyright 2012-2013 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.ap.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Provides functionality around the Java primitive data types and their wrapper
 * types.
 *
 * @author Gunnar Morling
 */
public class NativeTypes {

    private final static Map<Class<?>, Class<?>> wrapperToPrimitiveTypes;
    private final static Map<Class<?>, Class<?>> primitiveToWrapperTypes;

    static {
        Map<Class<?>, Class<?>> tmp = new HashMap<Class<?>, Class<?>>();
        tmp.put( Byte.class, byte.class );
        tmp.put( Short.class, short.class );
        tmp.put( Integer.class, int.class );
        tmp.put( Long.class, long.class );
        tmp.put( Float.class, float.class );
        tmp.put( Double.class, double.class );
        tmp.put( Boolean.class, boolean.class );
        tmp.put( Character.class, char.class );

        wrapperToPrimitiveTypes = Collections.unmodifiableMap( tmp );

        tmp = new HashMap<Class<?>, Class<?>>();
        tmp.put( byte.class, Byte.class );
        tmp.put( short.class, Short.class );
        tmp.put( int.class, Integer.class );
        tmp.put( long.class, Long.class );
        tmp.put( float.class, Float.class );
        tmp.put( double.class, Double.class );
        tmp.put( boolean.class, Boolean.class );
        tmp.put( char.class, Character.class );

        primitiveToWrapperTypes = Collections.unmodifiableMap( tmp );
    }

    public static Class<?> getWrapperType(Class<?> clazz) {
        if ( !clazz.isPrimitive() ) {
            throw new IllegalArgumentException( clazz + " is no primitive type." );
        }

        return primitiveToWrapperTypes.get( clazz );
    }

    public static Class<?> getPrimitiveType(Class<?> clazz) {
        if ( clazz.isPrimitive() ) {
            throw new IllegalArgumentException( clazz + " is no wrapper type." );
        }

        return wrapperToPrimitiveTypes.get( clazz );
    }
}