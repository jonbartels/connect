/* ***** BEGIN LICENSE BLOCK *****
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License Version
 * 1.1 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License
 * for the specific language governing rights and limitations under the
 * License.
 *
 * The Original Code is Mirth.
 *
 * The Initial Developer of the Original Code is
 * WebReach, Inc.
 * Portions created by the Initial Developer are Copyright (C) 2006
 * the Initial Developer. All Rights Reserved.
 *
 * Contributor(s):
 *   Gerald Bortis <geraldb@webreachinc.com>
 *
 * ***** END LICENSE BLOCK ***** */

package com.webreach.mirth.client.ui.connectors;

import java.util.Properties;
import java.util.StringTokenizer;

import com.webreach.mirth.client.ui.UIConstants;

/**
 * A form that extends from ConnectorClass. All methods implemented are
 * described in ConnectorClass.
 */
public class HTTPListener extends ConnectorClass
{
    /** Creates new form HTTPListener */
    private final String DATATYPE = "DataType";

    private final String HTTP_ADDRESS = "host";

    private final String HTTP_PORT = "port";

    private final String HTTP_RECEIVE_TIMEOUT = "receiveTimeout";

    private final String HTTP_BUFFER_SIZE = "bufferSize";

    private final String HTTP_KEEP_CONNECTION_OPEN = "keepSendSocketOpen";

    private final String HTTP_RESPONSE_FROM_TRANSFORMER = "responseFromTransformer";
    
    private final String HTTP_EXTENDED_PAYLOAD = "extendedPayload";
    public HTTPListener()
    {
        name = "HTTP Listener";
        initComponents();
        makeResponseStep();
    }

    public Properties getProperties()
    {
        Properties properties = new Properties();
        properties.put(DATATYPE, name);
        String listenerIPAddress = listenerIPAddressField.getText() + "." + listenerIPAddressField1.getText() + "." + listenerIPAddressField2.getText() + "." + listenerIPAddressField3.getText();
        properties.put(HTTP_ADDRESS, listenerIPAddress);
        properties.put(HTTP_PORT, listenerPortField.getText());
        properties.put(HTTP_RECEIVE_TIMEOUT, receiveTimeoutField.getText());
        properties.put(HTTP_BUFFER_SIZE, bufferSizeField.getText());
        properties.put(HTTP_EXTENDED_PAYLOAD, UIConstants.YES_OPTION);
        if (keepConnectionOpenYesRadio.isSelected())
            properties.put(HTTP_KEEP_CONNECTION_OPEN, UIConstants.YES_OPTION);
        else
            properties.put(HTTP_KEEP_CONNECTION_OPEN, UIConstants.NO_OPTION);

        if (responseFromTransformerYes.isSelected())
            properties.put(HTTP_RESPONSE_FROM_TRANSFORMER, UIConstants.YES_OPTION);
        else
            properties.put(HTTP_RESPONSE_FROM_TRANSFORMER, UIConstants.NO_OPTION);

        return properties;
    }

    public void setProperties(Properties props)
    {
        String listenerIPAddress = (String) props.get(HTTP_ADDRESS);
        StringTokenizer IP = new StringTokenizer(listenerIPAddress, ".");
        if (IP.hasMoreTokens())
            listenerIPAddressField.setText(IP.nextToken());
        else
            listenerIPAddressField.setText("");
        if (IP.hasMoreTokens())
            listenerIPAddressField1.setText(IP.nextToken());
        else
            listenerIPAddressField1.setText("");
        if (IP.hasMoreTokens())
            listenerIPAddressField2.setText(IP.nextToken());
        else
            listenerIPAddressField2.setText("");
        if (IP.hasMoreTokens())
            listenerIPAddressField3.setText(IP.nextToken());
        else
            listenerIPAddressField3.setText("");

        listenerPortField.setText((String) props.get(HTTP_PORT));
        receiveTimeoutField.setText((String) props.get(HTTP_RECEIVE_TIMEOUT));
        bufferSizeField.setText((String) props.get(HTTP_BUFFER_SIZE));

        if (((String) props.get(HTTP_KEEP_CONNECTION_OPEN)).equals(UIConstants.YES_OPTION))
            keepConnectionOpenYesRadio.setSelected(true);
        else
            keepConnectionOpenNoRadio.setSelected(true);

        if (((String) props.get(HTTP_RESPONSE_FROM_TRANSFORMER)).equals(UIConstants.YES_OPTION))
            responseFromTransformerYes.setSelected(true);
        else
            responseFromTransformerNo.setSelected(true);
    }

    public Properties getDefaults()
    {
        Properties properties = new Properties();
        properties.put(DATATYPE, name);
        properties.put(HTTP_ADDRESS, "127.0.0.1");
        properties.put(HTTP_PORT, "80");
        properties.put(HTTP_RECEIVE_TIMEOUT, "5000");
        properties.put(HTTP_BUFFER_SIZE, "65536");
        properties.put(HTTP_KEEP_CONNECTION_OPEN, UIConstants.NO_OPTION);
        properties.put(HTTP_RESPONSE_FROM_TRANSFORMER, UIConstants.NO_OPTION);
        properties.put(HTTP_EXTENDED_PAYLOAD, UIConstants.YES_OPTION); //always yes
        return properties;
    }

    public boolean checkProperties(Properties props)
    {
        if (((String) props.get(HTTP_ADDRESS)).length() > 0 && ((String) props.get(HTTP_PORT)).length() > 0 && ((String) props.get(HTTP_RECEIVE_TIMEOUT)).length() > 0 && ((String) props.get(HTTP_BUFFER_SIZE)).length() > 0)
            return true;
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code
    // ">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        keepConnectionOpenGroup = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bufferSizeField = new com.webreach.mirth.client.ui.components.MirthTextField();
        receiveTimeoutField = new com.webreach.mirth.client.ui.components.MirthTextField();
        listenerIPAddressField = new com.webreach.mirth.client.ui.components.MirthTextField();
        listenerPortField = new com.webreach.mirth.client.ui.components.MirthTextField();
        keepConnectionOpenYesRadio = new com.webreach.mirth.client.ui.components.MirthRadioButton();
        keepConnectionOpenNoRadio = new com.webreach.mirth.client.ui.components.MirthRadioButton();
        listenerIPAddressField1 = new com.webreach.mirth.client.ui.components.MirthTextField();
        listenerIPAddressField2 = new com.webreach.mirth.client.ui.components.MirthTextField();
        listenerIPAddressField3 = new com.webreach.mirth.client.ui.components.MirthTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        responseFromTransformerNo = new com.webreach.mirth.client.ui.components.MirthRadioButton();
        responseFromTransformerYes = new com.webreach.mirth.client.ui.components.MirthRadioButton();
        jLabel38 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jLabel1.setText("Listener IP Address:");

        jLabel2.setText("Listener Port:");

        jLabel3.setText("Receive Timeout (ms):");

        jLabel4.setText("Buffer Size:");

        jLabel5.setText("Keep Connection Open:");

        keepConnectionOpenYesRadio.setBackground(new java.awt.Color(255, 255, 255));
        keepConnectionOpenYesRadio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        keepConnectionOpenGroup.add(keepConnectionOpenYesRadio);
        keepConnectionOpenYesRadio.setText("Yes");
        keepConnectionOpenYesRadio.setMargin(new java.awt.Insets(0, 0, 0, 0));

        keepConnectionOpenNoRadio.setBackground(new java.awt.Color(255, 255, 255));
        keepConnectionOpenNoRadio.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        keepConnectionOpenGroup.add(keepConnectionOpenNoRadio);
        keepConnectionOpenNoRadio.setText("No");
        keepConnectionOpenNoRadio.setMargin(new java.awt.Insets(0, 0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText(".");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText(".");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText(".");

        responseFromTransformerNo.setBackground(new java.awt.Color(255, 255, 255));
        responseFromTransformerNo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonGroup1.add(responseFromTransformerNo);
        responseFromTransformerNo.setText("No");
        responseFromTransformerNo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        responseFromTransformerNo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                responseFromTransformerNoActionPerformed(evt);
            }
        });

        responseFromTransformerYes.setBackground(new java.awt.Color(255, 255, 255));
        responseFromTransformerYes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        buttonGroup1.add(responseFromTransformerYes);
        responseFromTransformerYes.setText("Yes");
        responseFromTransformerYes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        responseFromTransformerYes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                responseFromTransformerYesActionPerformed(evt);
            }
        });

        jLabel38.setText("Response from Transformer");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(layout.createSequentialGroup().addContainerGap().add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING).add(jLabel38).add(jLabel2).add(jLabel1).add(jLabel3).add(jLabel4).add(jLabel5)).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(layout.createSequentialGroup().add(keepConnectionOpenYesRadio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(keepConnectionOpenNoRadio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).add(receiveTimeoutField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(listenerPortField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 50, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(bufferSizeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 75, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(layout.createSequentialGroup().add(listenerIPAddressField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(jLabel6).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(listenerIPAddressField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(jLabel7).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(listenerIPAddressField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(jLabel8).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(listenerIPAddressField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).add(layout.createSequentialGroup().add(responseFromTransformerYes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(responseFromTransformerNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))).addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING).add(layout.createSequentialGroup().add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING).add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(listenerIPAddressField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(listenerIPAddressField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel1)).add(jLabel6).add(listenerIPAddressField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel8).add(listenerIPAddressField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel7)).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(listenerPortField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel2)).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(receiveTimeoutField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel3)).add(8, 8, 8).add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(bufferSizeField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel4)).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(keepConnectionOpenYesRadio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(keepConnectionOpenNoRadio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(jLabel5)).addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED).add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE).add(jLabel38).add(responseFromTransformerYes, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE).add(responseFromTransformerNo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)).addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void responseFromTransformerYesActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_responseFromTransformerYesActionPerformed
    {// GEN-HEADEREND:event_responseFromTransformerYesActionPerformed
        setResponseStep();
    }// GEN-LAST:event_responseFromTransformerYesActionPerformed

    private void responseFromTransformerNoActionPerformed(java.awt.event.ActionEvent evt)// GEN-FIRST:event_responseFromTransformerNoActionPerformed
    {// GEN-HEADEREND:event_responseFromTransformerNoActionPerformed
        removeResponseStep();
    }// GEN-LAST:event_responseFromTransformerNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.webreach.mirth.client.ui.components.MirthTextField bufferSizeField;

    private javax.swing.ButtonGroup buttonGroup1;

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;

    private javax.swing.JLabel jLabel3;

    private javax.swing.JLabel jLabel38;

    private javax.swing.JLabel jLabel4;

    private javax.swing.JLabel jLabel5;

    private javax.swing.JLabel jLabel6;

    private javax.swing.JLabel jLabel7;

    private javax.swing.JLabel jLabel8;

    private javax.swing.ButtonGroup keepConnectionOpenGroup;

    private com.webreach.mirth.client.ui.components.MirthRadioButton keepConnectionOpenNoRadio;

    private com.webreach.mirth.client.ui.components.MirthRadioButton keepConnectionOpenYesRadio;

    private com.webreach.mirth.client.ui.components.MirthTextField listenerIPAddressField;

    private com.webreach.mirth.client.ui.components.MirthTextField listenerIPAddressField1;

    private com.webreach.mirth.client.ui.components.MirthTextField listenerIPAddressField2;

    private com.webreach.mirth.client.ui.components.MirthTextField listenerIPAddressField3;

    private com.webreach.mirth.client.ui.components.MirthTextField listenerPortField;

    private com.webreach.mirth.client.ui.components.MirthTextField receiveTimeoutField;

    private com.webreach.mirth.client.ui.components.MirthRadioButton responseFromTransformerNo;

    private com.webreach.mirth.client.ui.components.MirthRadioButton responseFromTransformerYes;
    // End of variables declaration//GEN-END:variables

}
