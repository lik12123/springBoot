package com.fh.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

    public class Shop {

        private Integer shopId;

        private String shopName;
        private String imgPath;
        private Double shopPrice;
        private Integer isUp;
        private Date producedTime;
        private Integer sales;
        private Integer shopCount;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date createDate;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date updateDate;
        private String areaIds;
        private String typesIds;

        public Integer getShopId() {
            return shopId;
        }

        public void setShopId(Integer shopId) {
            this.shopId = shopId;
        }

        public String getShopName() {
            return shopName;
        }

        public void setShopName(String shopName) {
            this.shopName = shopName;
        }

        public String getImgPath() {
            return imgPath;
        }

        public void setImgPath(String imgPath) {
            this.imgPath = imgPath;
        }

        public Double getShopPrice() {
            return shopPrice;
        }

        public void setShopPrice(Double shopPrice) {
            this.shopPrice = shopPrice;
        }

        public Integer getIsUp() {
            return isUp;
        }

        public void setIsUp(Integer isUp) {
            this.isUp = isUp;
        }

        public Date getProducedTime() {
            return producedTime;
        }

        public void setProducedTime(Date producedTime) {
            this.producedTime = producedTime;
        }

        public Integer getSales() {
            return sales;
        }

        public void setSales(Integer sales) {
            this.sales = sales;
        }

        public Integer getShopCount() {
            return shopCount;
        }

        public void setShopCount(Integer shopCount) {
            this.shopCount = shopCount;
        }

        public Date getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Date createDate) {
            this.createDate = createDate;
        }

        public Date getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Date updateDate) {
            this.updateDate = updateDate;
        }

        public String getAreaIds() {
            return areaIds;
        }

        public void setAreaIds(String areaIds) {
            this.areaIds = areaIds;
        }

        public String getTypesIds() {
            return typesIds;
        }

        public void setTypesIds(String typesIds) {
            this.typesIds = typesIds;
        }
    }
