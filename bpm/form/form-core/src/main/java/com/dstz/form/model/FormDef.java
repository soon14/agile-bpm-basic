package com.dstz.form.model;

import com.dstz.base.core.model.BaseModel;
import com.dstz.form.api.model.IFormDef;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <pre>
 * 描述：表单对象
 * 作者:aschs
 * 邮箱:aschs@qq.com
 * 日期:2018年3月16日 下午4:19:26
 * 版权:summer
 * </pre>
 */
public class FormDef extends BaseModel implements IFormDef {
    /**
     * key
     */
    @NotEmpty
    private String key;
    /**
     * 名字
     */
    @NotEmpty
    private String name;
    /**
     * 描述
     */
    private String desc;
    /**
     * 分组id
     */
    private String groupId;
    /**
     * 分组名称
     */
    private String groupName;
    /**
     * 业务对象key
     */
    private String boKey;
    /**
     * 业务对象名称
     */
    private String boName;
    /**
     * <pre>
     * 表单内容
     * </pre>
     */
    private String html;
    
    private String creator;
    
    private String updator;

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#getKey()
	 */
    @Override
	public String getKey() {
        return key;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#setKey(java.lang.String)
	 */
    @Override
	public void setKey(String key) {
        this.key = key;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#getName()
	 */
    @Override
	public String getName() {
        return name;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#setName(java.lang.String)
	 */
    @Override
	public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#getDesc()
	 */
    @Override
	public String getDesc() {
        return desc;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#setDesc(java.lang.String)
	 */
    @Override
	public void setDesc(String desc) {
        this.desc = desc;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#getGroupId()
	 */
    @Override
	public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#getGroupName()
	 */
    @Override
	public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#getBoKey()
	 */
    @Override
	public String getBoKey() {
        return boKey;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#setBoKey(java.lang.String)
	 */
    @Override
	public void setBoKey(String boKey) {
        this.boKey = boKey;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#getBoName()
	 */
    @Override
	public String getBoName() {
        return boName;
    }

    public void setBoName(String boName) {
        this.boName = boName;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#getHtml()
	 */
    @Override
	public String getHtml() {
        return html;
    }

    /* (non-Javadoc)
	 * @see com.dstz.form.model.IFormDef#setHtml(java.lang.String)
	 */
    @Override
	public void setHtml(String html) {
        this.html = html;
    }

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

}
