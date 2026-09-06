package com.smarteducation.learning.service;

import com.smarteducation.common.domain.dto.PageDTO;
import com.smarteducation.learning.domain.dto.NoteFormDTO;
import com.smarteducation.learning.domain.po.Note;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smarteducation.learning.domain.query.NoteAdminPageQuery;
import com.smarteducation.learning.domain.query.NotePageQuery;
import com.smarteducation.learning.domain.vo.NoteAdminDetailVO;
import com.smarteducation.learning.domain.vo.NoteAdminVO;
import com.smarteducation.learning.domain.vo.NoteVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 虎哥
 */
public interface INoteService extends IService<Note> {

    void saveNote(NoteFormDTO noteDTO);

    void gatherNote(Long id);

    void removeGatherNote(Long id);

    void updateNote(NoteFormDTO noteDTO);

    PageDTO<NoteVO> queryNotePage(NotePageQuery query);

    PageDTO<NoteAdminVO> queryNotePageForAdmin(NoteAdminPageQuery query);

    NoteAdminDetailVO queryNoteDetailForAdmin(Long id);

    void hiddenNote(Long id, boolean hidden);

    void removeMyNote(Long id);
}
