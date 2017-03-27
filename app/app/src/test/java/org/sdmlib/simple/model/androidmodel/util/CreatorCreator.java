package org.sdmlib.simple.model.androidmodel.util;

import de.uniks.networkparser.IdMap;

class CreatorCreator{

   public static IdMap createIdMap(String sessionID)
   {
      IdMap jsonIdMap = new IdMap().withSessionId(sessionID);
      jsonIdMap.with(new UniversityCreator());
      jsonIdMap.with(new StudentCreator());
      return jsonIdMap;
   }
}
