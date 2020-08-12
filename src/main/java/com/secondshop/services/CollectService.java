package com.secondshop.services;

import com.secondshop.mappers.CollectMapper;
import com.secondshop.models.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectMapper collectMapper;

    /**
     * 删除收藏
     * @param collectId 收藏id
     * @return
     */
    @Transactional
    public Boolean deleteCollect(Integer collectId){
        return collectMapper.deleteCollect(collectId) > 0;
    }

    /**
     *  根据商品id和用户id查询收藏信息
     * @param goodId 商品id
     * @param userId 用户id
     * @return
     */
    @Transactional
    public Boolean getCollect(Integer goodId, Integer userId){
        return collectMapper.getCollect(goodId, userId) != null;
    }

    /**
     * 根据用户id查询收藏信息
     * @param userId 用户id
     * @return
     */
    @Transactional
    public List<Collect> getCollectByUserId(Integer userId){
        return collectMapper.getCollectByUserId(userId);
    }

    /**
     * 添加收藏
     * @param collect 收藏
     * @return
     */
    @Transactional
    public Boolean insertCollect(Collect collect){
        return collectMapper.insertCollect(collect) > 0;
    }
}
