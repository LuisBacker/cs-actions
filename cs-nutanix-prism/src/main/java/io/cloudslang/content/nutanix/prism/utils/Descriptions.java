/*
 * (c) Copyright 2020 Micro Focus, L.P.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Apache License v2.0 which accompany this distribution.
 *
 * The Apache License is available at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.cloudslang.content.nutanix.prism.utils;

public class Descriptions {
    public static class Common {
        public static final String PROXY_HOST_DESC = "Proxy server used to access the Nutanix service.";
        public static final String PROXY_PORT_DESC = "Proxy server port used to access the Nutanix service." +
                "Default: '8080'";
        public static final String PROXY_USERNAME_DESC = "Proxy server user name.";
        public static final String PROXY_PASSWORD_DESC = "Proxy server password associated with the proxy_username " +
                "input value.";
        public static final String TRUST_ALL_ROOTS_DESC = "Specifies whether to enable weak security over SSL/TSL. " +
                "A certificate is trusted even if no trusted certification authority issued it." +
                "Default: 'false'";
        public static final String X509_DESC = "Specifies the way the server hostname must match a domain name in " +
                "the subject's Common Name (CN) or subjectAltName field of the X.509 certificate. Set this to " +
                "\"allow_all\" to skip any checking. For the value \"browser_compatible\" the hostname verifier " +
                "works the same way as Curl and Firefox. The hostname must match either the first CN, or any of " +
                "the subject-alts. A wildcard can occur in the CN, and in any of the subject-alts. The only " +
                "difference between \"browser_compatible\" and \"strict\" is that a wildcard (such as \"*.foo.com\") " +
                "with \"browser_compatible\" matches all subdomains, including \"a.b.foo.com\"." +
                "Default: 'strict'";
        public static final String TRUST_KEYSTORE_DESC = "The pathname of the Java TrustStore file. This contains " +
                "certificates from other parties that you expect to communicate with, or from Certificate Authorities" +
                " that you trust to identify other parties.  If the protocol (specified by the 'url') is not 'https' " +
                "or if trustAllRoots is 'true' this input is ignored. Format: Java KeyStore (JKS)";
        public static final String TRUST_PASSWORD_DESC = "The password associated with the TrustStore file. If " +
                "trustAllRoots is false and trustKeystore is empty, trustPassword default will be supplied.";
        public static final String CONN_MAX_TOTAL_DESC = "The maximum limit of connections in total." +
                "Default: '20'";
        public static final String CONN_MAX_ROUTE_DESC = "The maximum limit of connections on a per route basis." +
                "Default: '2'";
        public static final String KEEP_ALIVE_DESC = "Specifies whether to create a shared connection that will be " +
                "used in subsequent calls. If keepAlive is false, the already open connection will be used and after" +
                " execution it will close it." +
                "Default: 'true'";
        public static final String SOCKET_TIMEOUT_DESC = "The timeout for waiting for data (a maximum period " +
                "inactivity between two consecutive data packets), in seconds. A socketTimeout value of '0' " +
                "represents an infinite timeout.";
        public static final String POLLING_INTERVAL_DESC = "The time, in seconds, to wait before a new request that " +
                "verifies if the operation finished is executed." +
                "Default: '1000'";
        public static final String CONNECT_TIMEOUT_DESC = "The time to wait for a connection to be established, " +
                "in seconds. A timeout value of '0' represents an infinite timeout." +
                "Default: '10000'";
        public static final String HOSTNAME_DESC = "The hostname for Nutanix.";
        public static final String PORT_DESC = "The port to connect to Nutanix. " +
                "Default: '9440'";
        public static final String USERNAME_DESC = "The username for Nutanix.";
        public static final String PASSWORD_DESC = "The password for Nutanix.";
        public static final String API_VERSION_DESC = "The api version for Nutanix. " +
                "Default: 'v2.0'";

        public static final String RETURN_CODE_DESC = "0 if success, -1 otherwise.";
        public static final String EXECUTION_TIMEOUT_DESC = "The amount of time (in milliseconds) to allow the client " +
                "to complete the execution of an API call. A value of '0' disables this feature." +
                "Default: '60000'";
        public static final String STATUS_CODE_DESC = "The HTTP status code for Nutanix API request.";
        public static final String EXCEPTION_DESC = "An error message in case there was an error while executing the " +
                "request.";
        public static final String FAILURE_DESC = "There was an error while executing the request.";
        public static final String SUCCESS_DESC = "The request was successfully executed.";
        public static final String RETURN_RESULT_DESC = "If successful, returns the complete API response. " +
                "In case of an error this output will contain the error message.";
        public static final String TASK_UUID_DESC = "The UUID of the Task that will be created in Nutanix after " +
                "submission of the API request.";
        public static final String VM_UUID_DESC = "Id of the Virtual Machine.";
    }


    public static class GetVMDetails {
        public static final String GET_VM_DETAILS_OPERATION_DESC = "Get details of a specific Virtual Machines. " +
                "Virtual Machine disk information and network information are not included by default as fetching " +
                "these are expensive operations. These can be included by setting the includeVMDiskConfig and " +
                "includeVMNicConfig flags respectively.";
        public static final String INCLUDE_VM_DISK_CONFIG_INFO_DESC = "Whether to include Virtual Machine disk " +
                "information." +
                "Default : 'true'";
        public static final String INCLUDE_VM_NIC_CONFIG_INFO_DESC = "Whether to include network information." +
                "Default : 'true'.";
        public static final String VM_NAME_DESC = "Name of the Virtual Machine.";
        public static final String IP_ADDRESS_DESC = "IP Address of the Virtual Machine.";
        public static final String POWER_STATE_DESC = "Current Power state of the Virtual Machine.";
        public static final String VM_DISK_UUID_DESC = "UUID of the disk attached to the Virtual Machine.";
        public static final String STORAGE_CONTAINER_UUID_DESC = "UUID of the storage container of the Virtual Machine.";
        public static final String VM_LOGICAL_TIMESTAMP_DESC = "The logical timestamp of the Virtual Machine.";
    }

    public static class ListVMsInputs {
        public static final String LIST_VMS_OPERATION_DESC = "Get a list of Virtual Machines." +
                "Virtual Machine disk information and network information are not included by default as fetching " +
                "these are expensive operations. These can be included by setting the include_vmdisk_config and " +
                "include_vmnic_config flags respectively.";
        public static final String FILTER_DESC = "Filter criteria - semicolon for AND, comma for OR.";
        public static final String OFFSET_DESC = "Offset.";
        public static final String LENGTH_DESC = "Number of VMs to retrieve.";
        public static final String SORT_ORDER_DESC = "Sort order.";
        public static final String SORT_ATTRIBUTE_DESC = "Sort attribute.";
        public static final String VM_LIST_DESC = "List of VM's.";
    }

    public static class CreateVM {
        public static final String CREATE_VM_OPERATION_DESC = "Create a Virtual Machine with specified configuration." +
                "This is an asynchronous operation that results in the creation of a task object. " +
                "The UUID of this task object is returned as the response of this operation. " +
                "This task can be monitored by using the /tasks/poll API.";
        public static final String VM_NAME_DESC = "Name of the Virtual Machine that will be created.";
        public static final String VM_DESCRIPTION_DESC = "The description of the Virtual Machine that will be created.";
        public static final String VM_MEMORY_SIZE_DESC = "The memory amount (in GiB) attached to the virtual machine " +
                "that will will be created.";
        public static final String NUM_VCPUS_DESC = "The number that indicates how many processors will have the " +
                "virtual machine that will be created.";
        public static final String NUM_CORES_PER_VCPU_DESC = "This is the number of cores per vCPU.";
        public static final String TIME_ZONE_DESC = "The timezone in which the Virtual Machine will be created." +
                "Example : 'Asia/Calcutta'";
        public static final String HYPERVISOR_TYPE_DESC = "The type hypervisor." +
                "Example : ACROPOLIS.";
        public static final String FLASH_MODE_ENABLED_DESC = "State of the storage policy to pin virtual disks to" +
                " the hot tier. When specified as a VM attribute, the storage policy applies to all virtual disks of " +
                "the VM unless overridden by the same attribute specified for a virtual disk." +
                "Default : 'false'";
        public static final String IS_SCSI_PASS_THROUGH_DESC = "If the value is 'true' Disks on the SCSI bus will be " +
                "configured for passthrough on platforms that support iSCSI." +
                "Default : 'false'";
        public static final String IS_THIN_PROVISIONED_DESC = "If the value is 'true' then Virtual Machine will be " +
                "created with thin provision." +
                "Default : 'true'";
        public static final String IS_CDROM_DESC = "If the value is 'true' then Virtual Machine needs to create " +
                "with CDROM otherwise Virtual Machine will be created with Empty Disk.";
        public static final String IS_EMPTY_DESC = "If the value is 'true' then Virtual Machine will created with Empty" +
                "Disk." +
                "Default : 'true'";
        public static final String DEVICE_BUS_DESC = "The type of Device disk." +
                "Allowed Values: SCSI, IDE, PCI, SATA, SPAPR.";
        public static final String DISK_LABEL_DESC = "The Label for the disk that will be created";
        public static final String DEVICE_INDEX_DESC = "The Index of the disk device." +
                "Default : '0'";
        public static final String NDFS_FILE_PATH_DESC = "The refernece ndfs file location from which the disk will be " +
                "created.";
        public static final String SOURCE_VM_DISK_UUID_DESC = "The reference disk UUID from which new disk will be " +
                "created.";
        public static final String VM_DISK_MINIMUM_SIZE_DESC = "The size of reference disk." +
                "Default : '0'";
        public static final String EXTERNAL_DISK_URL_DESC = "The URL of the external reference disk which will be " +
                "used to create a new disk.";
        public static final String EXTERNAL_DISK_SIZE_DESC = "The size of the external disk to be created." +
                "Default : '0'";
        public static final String STORAGE_CONTAINER_UUID_DESC = "The reference storage container UUID from which the " +
                "new storage container will be created.";
        public static final String VM_DISK_SIZE_DESC = "The size (in GiB) of the new storage container to be created." +
                "Default : '0'";
        public static final String NETWORK_UUID_DESC = "The network UUID which will be attached to the Virtual Machine";
        public static final String REQUESTED_IP_ADDRESS_DESC = "The static IP address which will be assigned to " +
                "the Virtual Machine.";
        public static final String IS_CONNECTED_DESC = "If the value of this property is 'true' the network will be " +
                "connected while booting the Virtual Machine.";
        public static final String HOST_UUIDS_DESC = "The Host UUIDs for which Virtual Machine will be mapped.";
        public static final String AGENT_VM_DESC = "Indicates whether the VM is an agent VM. When their host enters " +
                "maintenance mode, after normal VMs are evacuated, agent VMs are powered off. When the host is " +
                "restored, agent VMs are powered on before normal VMs are restored. In other words, agent VMs cannot " +
                "be HA-protected or live migrated." +
                "Default : 'false'";

    }

    public static class UpdateVM {
        public static final String UPDATE_VM_OPERATION_DESC = "Update a Virtual Machine with specified configuration." +
                "This is an asynchronous operation that results in the creation of a task object. " +
                "The UUID of this task object is returned as the response of this operation. " +
                "This task can be monitored by using the /tasks/poll API.";
        public static final String VM_NAME_DESC = "Name of the Virtual Machine that will be updated.";
        public static final String VM_DESCRIPTION_DESC = "The description of the Virtual Machine that will be updated.";
        public static final String VM_MEMORY_SIZE_DESC = "The memory amount (in GiB) attached to the virtual machine " +
                "that will will be updated.";
        public static final String NUM_VCPUS_DESC = "The number that indicates how many processors will have the " +
                "virtual machine that will be updated.";
        public static final String NUM_CORES_PER_VCPU_DESC = "This is the number of cores per vCPU.";
        public static final String TIME_ZONE_DESC = "The timezone in which the Virtual Machine will be updated." +
                "Example : 'Asia/Calcutta'";
        public static final String HYPERVISOR_TYPE_DESC = "The type hypervisor." +
                "Example : ACROPOLIS.";
        public static final String FLASH_MODE_ENABLED_DESC = "State of the storage policy to pin virtual disks to" +
                " the hot tier. When specified as a VM attribute, the storage policy applies to all virtual disks of " +
                "the VM unless overridden by the same attribute specified for a virtual disk." +
                "Default : 'false'";
        public static final String IS_SCSI_PASS_THROUGH_DESC = "If the value is 'true' Disks on the SCSI bus will be " +
                "configured for passthrough on platforms that support iSCSI." +
                "Default : 'false'";
        public static final String IS_THIN_PROVISIONED_DESC = "If the value is 'true' then Virtual Machine will be " +
                "created with thin provision." +
                "Default : 'true'";
        public static final String IS_CDROM_DESC = "If the value is 'true' then Virtual Machine needs to create " +
                "with CDROM otherwise Virtual Machine will be created with Empty Disk.";
        public static final String IS_EMPTY_DESC = "If the value is 'true' then Virtual Machine will created with Empty" +
                "Disk." +
                "Default : 'true'";
        public static final String DEVICE_BUS_DESC = "The type of Device disk." +
                "Allowed Values: SCSI, IDE, PCI, SATA, SPAPR.";
        public static final String DISK_LABEL_DESC = "The Label for the disk that will be updated";
        public static final String DEVICE_INDEX_DESC = "The Index of the disk device." +
                "Default : '0'";
        public static final String NDFS_FILE_PATH_DESC = "The refernece ndfs file location from which the disk will be " +
                "updated.";
        public static final String SOURCE_VM_DISK_UUID_DESC = "The reference disk UUID from which new disk will be " +
                "updated.";
        public static final String VM_DISK_MINIMUM_SIZE_DESC = "The size of reference disk." +
                "Default : '0'";
        public static final String EXTERNAL_DISK_URL_DESC = "The URL of the external reference disk which will be " +
                "used to create a new disk.";
        public static final String EXTERNAL_DISK_SIZE_DESC = "The size of the external disk to be created." +
                "Default : '0'";
        public static final String STORAGE_CONTAINER_UUID_DESC = "The reference storage container UUID from which the " +
                "new storage container will be updated.";
        public static final String VM_DISK_SIZE_DESC = "The size (in GiB) of the new storage container to be updated." +
                "Default : '0'";
        public static final String NETWORK_UUID_DESC = "The network UUID which will be attached to the Virtual Machine";
        public static final String REQUESTED_IP_ADDRESS_DESC = "The static IP address which will be assigned to " +
                "the Virtual Machine.";
        public static final String IS_CONNECTED_DESC = "If the value of this property is 'true' the network will be " +
                "connected while booting the Virtual Machine.";
        public static final String HOST_UUIDS_DESC = "The Host UUIDs for which Virtual Machine will be mapped.";
        public static final String AGENT_VM_DESC = "Indicates whether the VM is an agent VM. When their host enters " +
                "maintenance mode, after normal VMs are evacuated, agent VMs are powered off. When the host is " +
                "restored, agent VMs are powered on before normal VMs are restored. In other words, agent VMs cannot " +
                "be HA-protected or live migrated." +
                "Default : 'false'";

    }

    public static class GetTaskDetails {
        public static final String GET_TASK_DETAILS_OPERATION_DESC = "Get details of the specified task.";
        public static final String INCLUDE_SUBTASKS_INFO_DESC = "Whether to include a detailed information of the " +
                "immediate subtasks. " +
                "Default: 'false'";
        public static final String TASK_STATUS_DESC = "Status of the task.";

    }

    public static class DetachDisks {
        public static final String DETACH_DISKS_OPERATION_DESC = "Detach disks from Virtual Machine.";
        public static final String VM_DISK_UUID_LIST_DESC = "VM disk UUID list. If multiple disks need to be removed, add comma separated UUIDs.";
        public static final String DEVICE_BUS_LIST_DESC = "Device Bus List. List the device buses in the same order that the disk UUIDs are listed, separated by commas.\n"
                +"Valid values: sata,scsi,ide,pci";
        public static final String DEVICE_INDEX_LIST_DESC = "Device indices list. List the device index in the same order that the disk UUIDs are listed, separated by commas.";
        public static final String DETACH_DISKS_SUCCESS_DESC = "Disks successfully detached from the VM.";

    }
    public static class DeleteNIC {
        public static final String DELETE_NIC_OPERATION_DESC = "Delete a NIC from a Virtual Machine.";
        public static final String VM_LOGICAL_TIMESTAMP_DESC = "Virtual Machine Logical timestamp.";
        public static final String NIC_MAC_ADDRESS_DESC = "MAC address of Virtual Machine NIC identifier.";
        public static final String DELETE_NIC_SUCCESS_DESC = "Nic successfully deleted from the VM.";

    }

    public static class Counter{
        public static final String FAILURE_MESSAGE = "Something went wrong";
        public static final String COUNTER_DESC = "Counts from one number to another number.";
        public static final String RESULT_STRING_DESC = "The primary result is resultString, Result can also be used. " +
                "result (All lower case) should not be used as it is the response code.";
        public static final String RESULT_DESC = "If successful, returns the complete API response. In case of an " +
                "error this output will contain the error message.";
        public static final String FROM_DESC = "The number to start counting at.";
        public static final String TO_DESC = "The number to count to.";
        public static final String RESET_DESC = "If true, then the counter will restart counting from the beginning.";
        public static final String INCREMENT_BY_DESC = "The number to increment by while counting. If unspecified " +
                "this is 1. If you wanted to count 2,4,6,8 this would be 2.";


    }
}
