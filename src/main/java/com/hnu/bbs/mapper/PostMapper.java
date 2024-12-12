package com.hnu.bbs.mapper;

import com.hnu.bbs.entity.Post;
import com.hnu.bbs.entity.vo.PostVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 帖子表 Mapper 接口
 * </p>
 *
 * @author hnubbs
 * @since 2024-12-10
 */
@Mapper
public interface PostMapper extends BaseMapper<Post> {

     /**
     * 分页查询首页帖子列表
     * <p>
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> selectListAndPage(@Param("page") Page<PostVO> page, @Param("tab") String tab);

    /**
     * 获取详情页推荐
     *
     * @param id
     * @return
     */
    List<Post> selectRecommend(@Param("id") String id);

    /**
     * 全文检索
     *
     * @param page
     * @param keyword
     * @return
     */
    Page<PostVO> searchByKey(@Param("page") Page<PostVO> page, @Param("keyword") String keyword);
}
