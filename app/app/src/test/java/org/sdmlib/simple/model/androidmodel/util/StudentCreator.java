/*
   Copyright (c) 2017 Stefan
   
   Permission is hereby granted, free of charge, to any person obtaining a copy of this software 
   and associated documentation files (the "Software"), to deal in the Software without restriction, 
   including without limitation the rights to use, copy, modify, merge, publish, distribute, 
   sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is 
   furnished to do so, subject to the following conditions: 
   
   The above copyright notice and this permission notice shall be included in all copies or 
   substantial portions of the Software. 
   
   The Software shall be used for Good, not Evil. 
   
   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING 
   BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
   NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
   DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
   
package org.sdmlib.simple.model.androidmodel.util;

import de.uniks.networkparser.interfaces.SendableEntityCreator;
import org.sdmlib.simple.model.androidmodel.Student;
import de.uniks.networkparser.IdMap;
import org.sdmlib.simple.model.androidmodel.University;

public class StudentCreator implements SendableEntityCreator
{
   private final String[] properties = new String[]
   {
      Student.PROPERTY_NAME,
      Student.PROPERTY_UNI,
   };
   
   @Override
   public String[] getProperties()
   {
      return properties;
   }
   
   @Override
   public Object getSendableInstance(boolean reference)
   {
      return new Student();
   }
   
   @Override
   public Object getValue(Object target, String attrName)
   {
      int pos = attrName.indexOf('.');
      String attribute = attrName;
      
      if (pos > 0)
      {
         attribute = attrName.substring(0, pos);
      }

      if (Student.PROPERTY_NAME.equalsIgnoreCase(attribute))
      {
         return ((Student) target).getName();
      }

      if (Student.PROPERTY_UNI.equalsIgnoreCase(attribute))
      {
         return ((Student) target).getUni();
      }
      
      return null;
   }
   
   @Override
   public boolean setValue(Object target, String attrName, Object value, String type)
   {
      if (Student.PROPERTY_NAME.equalsIgnoreCase(attrName))
      {
         ((Student) target).setName((String) value);
         return true;
      }

      if (SendableEntityCreator.REMOVE.equals(type) && value != null)
      {
         attrName = attrName + type;
      }

      if (Student.PROPERTY_UNI.equalsIgnoreCase(attrName))
      {
         ((Student) target).setUni((University) value);
         return true;
      }
      
      return false;
   }
   public static IdMap createIdMap(String sessionID)
   {
      return org.sdmlib.simple.model.androidmodel.util.CreatorCreator.createIdMap(sessionID);
   }
   
   //==========================================================================
      public void removeObject(Object entity)
   {
      ((Student) entity).removeYou();
   }
}
