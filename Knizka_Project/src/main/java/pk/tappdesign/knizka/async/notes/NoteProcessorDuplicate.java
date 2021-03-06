/*
 * Copyright (C) 2020 TappDesign Studios
 * Copyright (C) 2013-2020 Federico Iosue (federico@iosue.it)
 *
 * This software is based on Omni-Notes project developed by Federico Iosue
 * https://github.com/federicoiosue/Omni-Notes
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pk.tappdesign.knizka.async.notes;

import java.util.List;

import de.greenrobot.event.EventBus;
import pk.tappdesign.knizka.async.bus.NotesDeletedEvent;
import pk.tappdesign.knizka.async.bus.NotesDuplicatedEvent;
import pk.tappdesign.knizka.db.DbHelper;
import pk.tappdesign.knizka.models.Note;

public class NoteProcessorDuplicate extends NoteProcessor {


   public NoteProcessorDuplicate(List<Note> notes) {
      super(notes);

   }


   @Override
   protected void processNote(Note note) {
      DbHelper.getInstance().duplicateNote(note);
   }

   @Override
   protected void afterProcess(List<Note> notes) {
      EventBus.getDefault().post(new NotesDuplicatedEvent(notes));
   }

}

