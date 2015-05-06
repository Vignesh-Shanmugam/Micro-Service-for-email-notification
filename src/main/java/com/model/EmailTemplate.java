package com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "email")
public class EmailTemplate {

    /**
     * email from section.
     */
    protected String from;

    /**
     * email to section.
     */
    protected String to;

    /**
     * email cc section.
     */
    protected String cc;

    /**
     * email bcc section.
     */
    protected String bcc;

    /**
     * email subject section.
     */
    protected String subject;

    /**
     * email body section.
     */
    protected String body;

    /**
     * Gets email from section.
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets email from section.
     * @param from the from to set
     */
    @XmlElement(required = true)
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Gets email to section.
     * @return the to
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets email to section.
     * @param to the to to set
     */
    @XmlElement(required = true)
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * Gets email cc section.
     * @return the cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * Sets email cc section.
     * @param cc the cc to set
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * Gets email bcc section.
     * @return the bcc
     */
    public String getBcc() {
        return bcc;
    }

    /**
     * Sets email bcc section.
     * @param bcc the bcc to set
     */
    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    /**
     * Gets email subject section.
     * @return the subject
     */

    public String getSubject() {
        return subject;
    }

    /**
     * Sets email subject section.
     * @param subject the subject to set
     */
    @XmlElement(required = true)
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets email body section.
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets email body section.
     * @param body the body to set
     */
    @XmlElement(required = true)
    public void setBody(String body) {
        this.body = body;
    }

	@Override
	public String toString() {
		return "EmailTemplate [from=" + from + ", to=" + to + ", cc=" + cc
				+ ", bcc=" + bcc + ", subject=" + subject + ", body=" + body
				+ "]";
	}

   
}
