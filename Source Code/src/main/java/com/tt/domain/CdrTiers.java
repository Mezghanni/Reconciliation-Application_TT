package com.tt.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.tt.commons.domain.CdrEntity;

@Entity
@Table(name="CDR_TIERS")
public class CdrTiers extends CdrEntity {
	private static final long serialVersionUID = 5052006698303433385L;

}
