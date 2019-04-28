package sharding.jdbc.dbconf.pojo;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "app_bill_install")
public class AppBillInstall {
    /**
     * 工单编号
     */
    @Id
    @Column(name = "case_id")
    private Long caseId;

    /**
     * 卡号
     */
    private String cardnbr;

    /**
     * 受理人工号
     */
    @Column(name = "staff_id")
    private String staffId;

    /**
     * 申请金额
     */
    @Column(name = "apply_amount")
    private BigDecimal applyAmount;

    /**
     * 分期期数
     */
    @Column(name = "install_number")
    private Integer installNumber;

    /**
     * 每期手续费
     */
    @Column(name = "procedure_fee")
    private BigDecimal procedureFee;

    /**
     * 每期本金
     */
    private BigDecimal pricipal;

    /**
     * 每期应还金额
     */
    @Column(name = "item_payment")
    private BigDecimal itemPayment;

    /**
     * 来电号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 是否需要回复
     */
    @Column(name = "need_reply")
    private String needReply;

    /**
     * 联系人姓名
     */
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 联系人性别
     */
    @Column(name = "contact_gender")
    private String contactGender;

    /**
     * 联系方式1
     */
    @Column(name = "contact_info_1")
    private String contactInfo1;

    /**
     * 联系方式２
     */
    @Column(name = "contact_info_2")
    private String contactInfo2;

    /**
     * 联系方式3
     */
    @Column(name = "contact_info_3")
    private String contactInfo3;

    /**
     * 最终批核金额
     */
    @Column(name = "approve_amt")
    private BigDecimal approveAmt;

    /**
     * 最终批核期数
     */
    @Column(name = "approve_terms")
    private Integer approveTerms;

    /**
     * 获取工单编号
     *
     * @return case_id - 工单编号
     */
    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    /**
     * 获取卡号
     *
     * @return cardnbr - 卡号
     */
    public String getCardnbr() {
        return cardnbr;
    }

    /**
     * 设置卡号
     *
     * @param cardnbr 卡号
     */
    public void setCardnbr(String cardnbr) {
        this.cardnbr = cardnbr;
    }

    /**
     * 获取受理人工号
     *
     * @return staff_id - 受理人工号
     */
    public String getStaffId() {
        return staffId;
    }

    /**
     * 设置受理人工号
     *
     * @param staffId 受理人工号
     */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取申请金额
     *
     * @return apply_amount - 申请金额
     */
    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    /**
     * 设置申请金额
     *
     * @param applyAmount 申请金额
     */
    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    /**
     * 获取分期期数
     *
     * @return install_number - 分期期数
     */
    public Integer getInstallNumber() {
        return installNumber;
    }

    /**
     * 设置分期期数
     *
     * @param installNumber 分期期数
     */
    public void setInstallNumber(Integer installNumber) {
        this.installNumber = installNumber;
    }

    /**
     * 获取每期手续费
     *
     * @return procedure_fee - 每期手续费
     */
    public BigDecimal getProcedureFee() {
        return procedureFee;
    }

    /**
     * 设置每期手续费
     *
     * @param procedureFee 每期手续费
     */
    public void setProcedureFee(BigDecimal procedureFee) {
        this.procedureFee = procedureFee;
    }

    /**
     * 获取每期本金
     *
     * @return pricipal - 每期本金
     */
    public BigDecimal getPricipal() {
        return pricipal;
    }

    /**
     * 设置每期本金
     *
     * @param pricipal 每期本金
     */
    public void setPricipal(BigDecimal pricipal) {
        this.pricipal = pricipal;
    }

    /**
     * 获取每期应还金额
     *
     * @return item_payment - 每期应还金额
     */
    public BigDecimal getItemPayment() {
        return itemPayment;
    }

    /**
     * 设置每期应还金额
     *
     * @param itemPayment 每期应还金额
     */
    public void setItemPayment(BigDecimal itemPayment) {
        this.itemPayment = itemPayment;
    }

    /**
     * 获取来电号码
     *
     * @return phone_number - 来电号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置来电号码
     *
     * @param phoneNumber 来电号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取是否需要回复
     *
     * @return need_reply - 是否需要回复
     */
    public String getNeedReply() {
        return needReply;
    }

    /**
     * 设置是否需要回复
     *
     * @param needReply 是否需要回复
     */
    public void setNeedReply(String needReply) {
        this.needReply = needReply;
    }

    /**
     * 获取联系人姓名
     *
     * @return contact_name - 联系人姓名
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人姓名
     *
     * @param contactName 联系人姓名
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 获取联系人性别
     *
     * @return contact_gender - 联系人性别
     */
    public String getContactGender() {
        return contactGender;
    }

    /**
     * 设置联系人性别
     *
     * @param contactGender 联系人性别
     */
    public void setContactGender(String contactGender) {
        this.contactGender = contactGender;
    }

    /**
     * 获取联系方式1
     *
     * @return contact_info_1 - 联系方式1
     */
    public String getContactInfo1() {
        return contactInfo1;
    }

    /**
     * 设置联系方式1
     *
     * @param contactInfo1 联系方式1
     */
    public void setContactInfo1(String contactInfo1) {
        this.contactInfo1 = contactInfo1;
    }

    /**
     * 获取联系方式２
     *
     * @return contact_info_2 - 联系方式２
     */
    public String getContactInfo2() {
        return contactInfo2;
    }

    /**
     * 设置联系方式２
     *
     * @param contactInfo2 联系方式２
     */
    public void setContactInfo2(String contactInfo2) {
        this.contactInfo2 = contactInfo2;
    }

    /**
     * 获取联系方式3
     *
     * @return contact_info_3 - 联系方式3
     */
    public String getContactInfo3() {
        return contactInfo3;
    }

    /**
     * 设置联系方式3
     *
     * @param contactInfo3 联系方式3
     */
    public void setContactInfo3(String contactInfo3) {
        this.contactInfo3 = contactInfo3;
    }

    /**
     * 获取最终批核金额
     *
     * @return approve_amt - 最终批核金额
     */
    public BigDecimal getApproveAmt() {
        return approveAmt;
    }

    /**
     * 设置最终批核金额
     *
     * @param approveAmt 最终批核金额
     */
    public void setApproveAmt(BigDecimal approveAmt) {
        this.approveAmt = approveAmt;
    }

    /**
     * 获取最终批核期数
     *
     * @return approve_terms - 最终批核期数
     */
    public Integer getApproveTerms() {
        return approveTerms;
    }

    /**
     * 设置最终批核期数
     *
     * @param approveTerms 最终批核期数
     */
    public void setApproveTerms(Integer approveTerms) {
        this.approveTerms = approveTerms;
    }
}