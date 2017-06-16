/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 ~ Copyright 2016 Adobe Systems Incorporated
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

package com.adobe.livetrials.models;

import org.osgi.annotation.versioning.ConsumerType;

/**
 * Defines the {@code Title} Sling Model used for the {@code /apps/core/wcm/components/title} component.
 */
@ConsumerType
public interface Title {

    /**
     * Name of the configuration policy property that will store the default value for this title's HTML element type.
     *
     * @see #getType()
     */
    String PN_DESIGN_DEFAULT_TYPE = "type";

    /**
     * Returns the text to be displayed as title.
     *
     * @return the title's text
     */
    String getText();

    /**
     * Returns the HTML element type (h1-h6) used for the markup.
     *
     * @return the element type
     */
    String getType();
}
