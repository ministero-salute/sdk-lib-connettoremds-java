/* SPDX-License-Identifier: BSD-3-Clause */

package it.mds.sdk.connettoremds.parser.xml;

import it.mds.sdk.connettoremds.parser.xml.exception.ValidazioneFirmaException;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Slf4j
public class ReadSignedFile {
	public byte[] getOriginalDocumentBinaries(final byte[] signedDoc) throws ValidazioneFirmaException {
		ASN1InputStream asn1InputStream = null;
		try {
			asn1InputStream = new ASN1InputStream(new ByteArrayInputStream(signedDoc));
			ASN1Object signedContent = null;
			try {
				signedContent = asn1InputStream.readObject();
			} catch (IOException cause) {
				log.error("Error reading stream "+cause.getMessage());
				throw new ValidazioneFirmaException(cause.getMessage());
			}
			CMSSignedData cmsSignedData = null;
			try {
				cmsSignedData = new CMSSignedData(ContentInfo.getInstance(signedContent));
			} catch (IllegalArgumentException cause2) {
				log.error("Error "+cause2.getMessage());
				throw new ValidazioneFirmaException(cause2.getMessage());
			} catch (Throwable cause2) {
				log.error("Error "+cause2.getMessage());
				throw new ValidazioneFirmaException(cause2.getMessage());
			}
			return (byte[]) ((CMSProcessableByteArray) cmsSignedData.getSignedContent()).getContent();
		} catch (Exception ex) {
			log.error("Error "+ex.getMessage());
			throw new ValidazioneFirmaException(ex.getMessage());
		} finally {
			try {
				asn1InputStream.close();  //NOSONAR
			} catch (IOException ex) {
				log.error("Error "+ex.getMessage());
			}
		}

	}
}
