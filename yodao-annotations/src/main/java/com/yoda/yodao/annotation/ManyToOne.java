/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.yoda.yodao.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This annotation defines a single-valued association to another 
 * entity class that has many-to-one multiplicity. It is not normally 
 * necessary to specify the target entity explicitly since it can 
 * usually be inferred from the type of the object being referenced.
 *
 * <pre>
 *
 *     Example:
 *
 *     &#064;ManyToOne(optional=false) 
 *     &#064;JoinColumn(name="CUST_ID", nullable=false, updatable=false)
 *     public Customer getCustomer() { return customer; }
 * </pre>
 *
 * @since Java Persistence 1.0
 */
@Target({METHOD, FIELD}) 
@Retention(CLASS)

public @interface ManyToOne {

    /** 
     * (Optional) The entity class that is the target of 
     * the association. 
     *
     * <p> Defaults to the type of the field or property 
     * that stores the association. 
     */
    Class targetEntity() default void.class;

    /**
     * (Optional) The operations that must be cascaded to 
     * the target of the association.
     *
     * <p> By default no operations are cascaded.
     */
    CascadeType[] cascade() default {};

    /** 
     * (Optional) Whether the association should be lazily 
     * loaded or must be eagerly fetched. The {@link FetchType#EAGER EAGER} 
     * strategy is a requirement on the persistence provider runtime that 
     * the associated entity must be eagerly fetched. The {@link FetchType#LAZY 
     * LAZY} strategy is a hint to the persistence provider runtime.
     */
    FetchType fetch() default FetchType.EAGER;

    /** 
     * (Optional) Whether the association is optional. If set 
     * to false then a non-null relationship must always exist.
     */
    boolean optional() default true;
}
