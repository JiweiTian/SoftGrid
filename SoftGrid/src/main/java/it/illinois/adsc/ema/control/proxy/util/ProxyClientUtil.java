/* Copyright (C) 2016 Advanced Digital Science Centre

        * This file is part of Soft-Grid.
        * For more information visit https://www.illinois.adsc.com.sg/cybersage/
        *
        * Soft-Grid is free software: you can redistribute it and/or modify
        * it under the terms of the GNU General Public License as published by
        * the Free Software Foundation, either version 3 of the License, or
        * (at your option) any later version.
        *
        * Soft-Grid is distributed in the hope that it will be useful,
        * but WITHOUT ANY WARRANTY; without even the implied warranty of
        * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
        * GNU General Public License for more details.
        *
        * You should have received a copy of the GNU General Public License
        * along with Soft-Grid.  If not, see <http://www.gnu.org/licenses/>.

        * @author Prageeth Mahendra Gunathilaka
*/
package it.illinois.adsc.ema.control.proxy.util;

import org.openmuc.openiec61850.BdaVisibleString;
import org.openmuc.openiec61850.FcModelNode;
import org.openmuc.openiec61850.ModelNode;

/**
 * Created by prageethmahendra on 18/2/2016.
 */
public class ProxyClientUtil {

    public static String getObjectReference(int qualifier) {
        switch (qualifier) {
            case 1:
                return "lineStatus";
            case 2:
                return "tapRatio";
            case 3:
                return "loadMW";
            default:
                return "";
        }
    }


    public static void setIedFeildValues(FcModelNode modCtlModel, int qualifier, Object valueObject) {
        switch (qualifier) {
            case 1:
                // line status
                boolean state = (Boolean) valueObject;
                if (state) {
                    ((BdaVisibleString) modCtlModel).setValue("Open");
                } else {
                    ((BdaVisibleString) modCtlModel).setValue("Closed");
                }
                break;
            case 2:
                // set float value command
                float value = (Float) valueObject;
                ((BdaVisibleString) modCtlModel).setValue(String.valueOf(value));
                break;
            default:
        }
    }

    public static ParameterType getObjectVariableType(String variableName) {
        switch (variableName) {
            case "lineStatus":
                return ParameterType.BRANCH_LINE_STATUS;
            case "tapRatio":
            case "overloadRank":
            case "frequency":
            default:
                return ParameterType.FLOAT_VALUE;
        }
    }

    public static DeviceType getDeviceType(FcModelNode modelNodes) {
        if (modelNodes != null) {
            for (ModelNode modelNode : modelNodes.getChildren()) {
                if (modelNode.getName().contains("IED_Bus")) {
                    return DeviceType.BUS;
                } else if (modelNode.getName().contains("CB")) {
                    return DeviceType.BRANCH;
                } else if (modelNode.getName().contains("GEN")) {
                    return DeviceType.GENERATOR;
                } else if (modelNode.getName().contains("Shunt")) {
                    return DeviceType.SHUNT;
                } else if (modelNode.getName().contains("Transformer")) {
                    return DeviceType.TRANSFORMER;
                } else if (modelNode.getName().contains("Load")) {
                    return DeviceType.LOAD;
                }
            }
        }
        return DeviceType.MONITOR;
    }
}
