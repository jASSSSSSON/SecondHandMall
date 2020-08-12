package com.secondshop.services;

import com.secondshop.mappers.GoodMapper;
import com.secondshop.models.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GoodService {




	/**
	 * 构造函数注入
	 */
	@Autowired
	private GoodMapper goodMapper;


	/**
	 *查询商品信息
	 * @param offset 开始
	 * @param limit  结束
	 * @return 商品信息
	 */
	@Transactional
	public List<Good> getAllGoods(int offset, int limit) {
		return goodMapper.getAllGoods(offset, limit);
	}


	/**
	 * 查询全部商品信息
	 * @return 全部商品信息
	 */
	@Transactional
	public List<Good> getAllGoodList() {
		return goodMapper.getAllGoodList();
	}

	/**
	 * 根据内容查询商品信息
	 * @param searchText 商品内容
	 * @param secondTypeId 二级类型id
	 * @param offset 开始
	 * @param limit 结束
	 * @return 商品信息
	 */

	@Transactional
	public List<Good> getGoodsBySearchAndType(String searchText,
			Integer secondTypeId, int offset, int limit) {
		if (!searchText.equals("")) {
			searchText = "%" + searchText + "%";
			return goodMapper.getGoodsBySearch(searchText, offset, limit);
		} else if (secondTypeId != null) {
			return goodMapper.getGoodsByType(secondTypeId, offset, limit);
		} else {
			return goodMapper.getAllGoods(offset, limit);
		}
	}

	/**
	 * 根据内容查询商品信息
	 * @param searchText 查询的内容
	 * @param secondTypeId 二级类型id
	 * @return 商品信息
	 */
	@Transactional
	public int getGoodsBySearchAndTypeCount(String searchText,
			Integer secondTypeId) {
		if (!searchText.equals("")) {
			searchText = "%" + searchText + "%";
			return goodMapper.getGoodsBySearchCount(searchText);
		} else if (secondTypeId != null) {
			return goodMapper.getGoodsByTypeCount(secondTypeId);
		} else {
			return goodMapper.getAllGoodsCount();
		}
	}

	/**
	 *  根据商品id查询商品信息
	 * @param goodId 商品id
	 * @return 商品信息
	 */
	@Transactional
	public Good getGoodById(int goodId) {
		return goodMapper.getGoodById(goodId);
	}

	/**
	 * 根据条件查询商品信息
	 * @param secondTypeId 二级类型id
	 * @param goodId  商品id
	 * @return 商品信息
	 */

	@Transactional
	public List<Good> getRECGoods(int secondTypeId, int goodId) {
		return goodMapper.getRECGoods(secondTypeId, goodId);
	}


	/**
	 *  根据用户id查询商品信息
	 * @param userId 用户id
	 * @return 商品信息
	 */
	@Transactional
	public List<Good> getGoodByUserId(Integer userId) {
		return goodMapper.getGoodByUserId(userId);
	}

	/**
	 *  根据用户id查询商品信息
	 * @param userId 用户id
	 * @return 商品信息
	 */
	@Transactional
	public List<Good> getGoodStatusByUserId(Integer userId) {
		return goodMapper.getGoodStatusByUserId(userId);
	}

	/**
	 *  添加商品
	 * @param good 商品
	 * @return
	 */
	@Transactional
	public int insertGood(Good good) {
		return goodMapper.insterGood(good);
	}

	/**
	 * 修改商品图片
	 * @param photoUrl 商品图片
	 * @param goodId 商品id
	 * @return 商品信息
	 */
	@Transactional
	public int updateGoodPhotoUrl(String photoUrl, Integer goodId) {
		return goodMapper.updateGoodPhotoUrl(photoUrl, goodId);
	}

	/**
	 * 根据状态id修改商品
	 * @param statusId 状态id
	 * @param goodId 商品id
	 * @return 商品信息
	 */
	@Transactional
	public int updateGoodStatusId(Integer statusId, Integer goodId) {
		return goodMapper.updateGoodStatusId(statusId, goodId);
	}

	/**
	 * 修改商品
	 * @param good 商品
	 * @return
	 */
	@Transactional
	public int updateGood(Good good) {
		return goodMapper.updateGood(good);
	}

	/**
	 * 根据商品id得到图片
	 * @param goodId 商品id
	 * @return
	 */
	@Transactional
	public String getPhotoUrlByGoodId(Integer goodId) {
		return goodMapper.getPhotoUrlByGoodId(goodId);
	}

	/**
	 * 删除商品
	 * @param goodId 商品id
	 * @return
	 */
	@Transactional
	public int deleteGood(Integer goodId) {
		return goodMapper.deleteGood(goodId);
	}

	/**
	 * 根据二类id查询商品信息
	 * @param secondTypeId 二类id
	 * @return
	 */
	@Transactional
	public List<Good> getGoodsAdminByType(Integer secondTypeId) {
		return goodMapper.getGoodsAdminByTypeId(secondTypeId);
	}
}
