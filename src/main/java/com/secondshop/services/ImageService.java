package com.secondshop.services;

import com.secondshop.mappers.ImageMapper;
import com.secondshop.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageService {
	@Autowired
	private ImageMapper imageMapper;

	/**
	 * 根据商品id得到图片
	 * @param goodId
	 * @return
	 */
	@Transactional
	public List<Image> getImageByGoodId(Integer goodId) {
		return imageMapper.getImageByGoodId(goodId);
	}

	/**
	 * 添加商品图片
	 * @param image 图片
	 * @return
	 */
	@Transactional
	public int insertImage(Image image) {
		return imageMapper.insertImage(image);
	}

	/**
	 * 根据商品id删除图片
	 * @param goodId 商品id
	 * @return
	 */
	@Transactional
	public int deleteImage(Integer goodId) {
		return imageMapper.deleteImage(goodId);
	}
}
