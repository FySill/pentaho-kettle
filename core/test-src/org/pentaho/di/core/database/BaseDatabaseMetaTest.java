/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2015 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.core.database;

import org.junit.Before;
import org.junit.Test;
import org.pentaho.di.core.row.ValueMetaInterface;

import java.sql.ResultSetMetaData;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BaseDatabaseMetaTest {
  private BaseDatabaseMeta baseDatabaseMeta;

  @Before
  public void setUp() throws Exception {
    baseDatabaseMeta = new GenericDatabaseMeta();
  }

  @Test
  public void testGetSequenceNoMaxValueOption() throws Exception {
    assertEquals( "NOMAXVALUE", baseDatabaseMeta.getSequenceNoMaxValueOption() );
  }

  @Test
  public void testSupportsAutoGeneratedKeys() throws Exception {
    assertTrue( baseDatabaseMeta.supportsAutoGeneratedKeys() );
  }

  @Test
  public void testCustomizeValueFromSQLType() throws Exception {
    assertNull( baseDatabaseMeta.customizeValueFromSQLType( mock( ValueMetaInterface.class ),
        mock( ResultSetMetaData.class ), 1 ) );
  }

  @Test
  public void testGetCreateTableStatement() throws Exception {
    assertEquals( "CREATE TABLE ", baseDatabaseMeta.getCreateTableStatement() );
  }
}
