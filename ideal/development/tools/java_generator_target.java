/*
 * Copyright 2014 The Ideal Authors. All rights reserved.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://developers.google.com/open-source/licenses/bsd
 */

package ideal.development.tools;

import ideal.library.elements.*;
import ideal.runtime.elements.*;
import javax.annotation.Nullable;
import ideal.runtime.reflections.*;
import ideal.runtime.logs.*;
import ideal.development.elements.*;
import ideal.development.actions.*;
import ideal.development.types.*;
import ideal.development.values.*;
import ideal.development.transformers.*;

public class java_generator_target extends type_processor_target {

  private @Nullable java_generator generator;

  public java_generator_target(simple_name the_name) {
    super(the_name);
  }

  @Override
  protected void setup(create_manager the_manager, analysis_context the_context) {
    generator = new java_generator(the_manager.process_jinterop(), the_context,
        new content_writer(the_manager.output_catalog(), null));
  }

  @Override
  protected void process_type(principal_type the_type) {
    generator.generate_for_type(the_type);
  }
}
