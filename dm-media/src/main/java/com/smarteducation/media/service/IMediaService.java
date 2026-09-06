package com.smarteducation.media.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smarteducation.common.domain.dto.PageDTO;
import com.smarteducation.media.domain.dto.MediaDTO;
import com.smarteducation.media.domain.dto.MediaUploadResultDTO;
import com.smarteducation.media.domain.po.Media;
import com.smarteducation.media.domain.query.MediaQuery;
import com.smarteducation.media.domain.vo.MediaVO;
import com.smarteducation.media.domain.vo.VideoPlayVO;

/**
 * <p>
 * 媒资表，主要是视频文件 服务类
 * </p>
 *
 * @author 虎哥
 * @since 2022-06-30
 */
public interface IMediaService extends IService<Media> {

    String getUploadSignature();

    VideoPlayVO getPlaySignatureBySectionId(Long fileId);

    MediaDTO save(MediaUploadResultDTO mediaResult);

    void updateMediaProcedureResult(Media media);

    void deleteMedia(String fileId);

    VideoPlayVO getPlaySignatureByMediaId(Long mediaId);

    PageDTO<MediaVO> queryMediaPage(MediaQuery query);
}
