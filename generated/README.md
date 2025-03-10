# org.openapitools.client - Kotlin client library for xminer-api

No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)

## Overview
This API client was generated by the [OpenAPI Generator](https://openapi-generator.tech) project.  By using the [openapi-spec](https://github.com/OAI/OpenAPI-Specification) from a remote server, you can easily generate an API client.

- API version: 0.1.0
- Package version: 
- Generator version: 7.10.0
- Build package: org.openapitools.codegen.languages.KotlinClientCodegen

## Requires

* Kotlin 1.7.21
* Gradle 7.5

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a id="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to */api/v1*

| Class | Method | HTTP request | Description |
| ------------ | ------------- | ------------- | ------------- |
| *ApikeysApi* | [**apikeysAdd**](docs/ApikeysApi.md#apikeysadd) | **POST** /apikeys | Add api key |
| *ApikeysApi* | [**apikeysDelete**](docs/ApikeysApi.md#apikeysdelete) | **POST** /apikeys/delete | Delete api key |
| *ApikeysApi* | [**apikeysGet**](docs/ApikeysApi.md#apikeysget) | **GET** /apikeys | Get apikeys |
| *AuthApi* | [**authCheck**](docs/AuthApi.md#authcheck) | **GET** /auth-check | Auth Check |
| *AuthApi* | [**lock**](docs/AuthApi.md#lock) | **POST** /lock | Lock miner |
| *AuthApi* | [**lockOthers**](docs/AuthApi.md#lockothers) | **POST** /lock/others | Lock other miner sessions |
| *AuthApi* | [**unlock**](docs/AuthApi.md#unlock) | **POST** /unlock | Auth Check |
| *AutotuneApi* | [**autotunePresets**](docs/AutotuneApi.md#autotunepresets) | **GET** /autotune/presets | Get autotune preset list |
| *AutotuneApi* | [**autotuneReset**](docs/AutotuneApi.md#autotunereset) | **POST** /autotune/reset | Autotune reset list of profiles |
| *AutotuneApi* | [**autotuneResetAll**](docs/AutotuneApi.md#autotuneresetall) | **POST** /autotune/reset-all | Autotune reset all profiles |
| *FirmwareApi* | [**firmwareRemove**](docs/FirmwareApi.md#firmwareremove) | **POST** /firmware/remove | Remove firmware and boot from stock |
| *FirmwareApi* | [**firmwareUpdate**](docs/FirmwareApi.md#firmwareupdate) | **POST** /firmware/update | Update firmware |
| *LogsApi* | [**logsClear**](docs/LogsApi.md#logsclear) | **POST** /logs/{log_type}/clear | Clear logs |
| *LogsApi* | [**logsGet**](docs/LogsApi.md#logsget) | **GET** /logs/{log_type} | Read log file |
| *MetricsApi* | [**metrics**](docs/MetricsApi.md#metrics) | **GET** /metrics | Get metrics |
| *MiningApi* | [**miningPause**](docs/MiningApi.md#miningpause) | **POST** /mining/pause | Mining pause |
| *MiningApi* | [**miningRestart**](docs/MiningApi.md#miningrestart) | **POST** /mining/restart | Mining restart |
| *MiningApi* | [**miningResume**](docs/MiningApi.md#miningresume) | **POST** /mining/resume | Mining resume |
| *MiningApi* | [**miningStart**](docs/MiningApi.md#miningstart) | **POST** /mining/start | Mining start |
| *MiningApi* | [**miningStop**](docs/MiningApi.md#miningstop) | **POST** /mining/stop | Mining stop |
| *MiningApi* | [**miningSwitchPool**](docs/MiningApi.md#miningswitchpool) | **POST** /mining/switch-pool | Mining switch pool |
| *OtherApi* | [**findMiner**](docs/OtherApi.md#findminer) | **POST** /find-miner | Find miner |
| *OtherApi* | [**getChains**](docs/OtherApi.md#getchains) | **GET** /chains | Get miner chains |
| *OtherApi* | [**getChainsFactoryInfo**](docs/OtherApi.md#getchainsfactoryinfo) | **GET** /chains/factory-info | Get miner chains factory info |
| *OtherApi* | [**getChips**](docs/OtherApi.md#getchips) | **GET** /chips | Get miner chips. Deprecated. Use /chains route instead |
| *OtherApi* | [**getInfo**](docs/OtherApi.md#getinfo) | **GET** /info | Get miner info |
| *OtherApi* | [**layout**](docs/OtherApi.md#layout) | **GET** /layout | Layout |
| *OtherApi* | [**perfSummary**](docs/OtherApi.md#perfsummary) | **GET** /perf-summary | Summary |
| *OtherApi* | [**status**](docs/OtherApi.md#status) | **GET** /status | Get status |
| *OtherApi* | [**summary**](docs/OtherApi.md#summary) | **GET** /summary | Summary |
| *OtherApi* | [**ui**](docs/OtherApi.md#ui) | **GET** /ui | UI |
| *SettingsApi* | [**settingsBackup**](docs/SettingsApi.md#settingsbackup) | **POST** /settings/backup | Settings backup |
| *SettingsApi* | [**settingsFactoryReset**](docs/SettingsApi.md#settingsfactoryreset) | **POST** /settings/factory-reset | Settings factory reset |
| *SettingsApi* | [**settingsGet**](docs/SettingsApi.md#settingsget) | **GET** /settings | Get all miner settings |
| *SettingsApi* | [**settingsRestore**](docs/SettingsApi.md#settingsrestore) | **POST** /settings/restore | Settings restore |
| *SettingsApi* | [**settingsSave**](docs/SettingsApi.md#settingssave) | **POST** /settings | Save miner settings |
| *SystemApi* | [**systemReboot**](docs/SystemApi.md#systemreboot) | **POST** /system/reboot | System reboot |
| *WarrantyApi* | [**warrantyActivate**](docs/WarrantyApi.md#warrantyactivate) | **POST** /activate-warranty | Warranty activate |
| *WarrantyApi* | [**warrantyCancel**](docs/WarrantyApi.md#warrantycancel) | **POST** /cancel-warranty | Warranty cancel |


<a id="documentation-for-models"></a>
## Documentation for Models

 - [com.natio21.nocoiner_control.openapi.client.models.AddApiKeyRes](docs/AddApiKeyRes.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AddApiKeyStatus](docs/AddApiKeyStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AdvancedSettings](docs/AdvancedSettings.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AntmChain](docs/AntmChain.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AntmChainChips](docs/AntmChainChips.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AntmChainChipsStats](docs/AntmChainChipsStats.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AntmChainsChipsStats](docs/AntmChainsChipsStats.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AntmChip](docs/AntmChip.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AntmChipSensor](docs/AntmChipSensor.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AntmMinerStats](docs/AntmMinerStats.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AntmiChipStats](docs/AntmiChipStats.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ApiKeysJsonItem](docs/ApiKeysJsonItem.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AutotuneChain](docs/AutotuneChain.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AutotunePresetDto](docs/AutotunePresetDto.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AutotunePresetStatus](docs/AutotunePresetStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AutotunePresetsItem](docs/AutotunePresetsItem.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AutotuneReset](docs/AutotuneReset.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AutotuneResetAll](docs/AutotuneResetAll.md)
 - [com.natio21.nocoiner_control.openapi.client.models.AutotuneResultsItem](docs/AutotuneResultsItem.md)
 - [com.natio21.nocoiner_control.openapi.client.models.CgChainStatus](docs/CgChainStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ChainChipStatuses](docs/ChainChipStatuses.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ChainRaw](docs/ChainRaw.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ChainState](docs/ChainState.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ChainStatus](docs/ChainStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ChipGrade](docs/ChipGrade.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Consts](docs/Consts.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Cooling](docs/Cooling.md)
 - [com.natio21.nocoiner_control.openapi.client.models.CoolingConsts](docs/CoolingConsts.md)
 - [com.natio21.nocoiner_control.openapi.client.models.CoolingSettingsRaw](docs/CoolingSettingsRaw.md)
 - [com.natio21.nocoiner_control.openapi.client.models.CurrentPreset](docs/CurrentPreset.md)
 - [com.natio21.nocoiner_control.openapi.client.models.DeleteApikeyQuery](docs/DeleteApikeyQuery.md)
 - [com.natio21.nocoiner_control.openapi.client.models.DiagReportQueryInput](docs/DiagReportQueryInput.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ErrDescr](docs/ErrDescr.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FactoryInfoChain](docs/FactoryInfoChain.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FactoryInfoReply](docs/FactoryInfoReply.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Fan](docs/Fan.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FanMode](docs/FanMode.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FanSettings](docs/FanSettings.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FanSettingsOneOf](docs/FanSettingsOneOf.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FanSettingsOneOfMode](docs/FanSettingsOneOfMode.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FanStatus](docs/FanStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FindMinerStatus](docs/FindMinerStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.FwInfo](docs/FwInfo.md)
 - [com.natio21.nocoiner_control.openapi.client.models.GlobalsRaw](docs/GlobalsRaw.md)
 - [com.natio21.nocoiner_control.openapi.client.models.HrMeasure](docs/HrMeasure.md)
 - [com.natio21.nocoiner_control.openapi.client.models.InfoJson](docs/InfoJson.md)
 - [com.natio21.nocoiner_control.openapi.client.models.InputConfig](docs/InputConfig.md)
 - [com.natio21.nocoiner_control.openapi.client.models.InputNetworkConfFile](docs/InputNetworkConfFile.md)
 - [com.natio21.nocoiner_control.openapi.client.models.InstallType](docs/InstallType.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Layout](docs/Layout.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Locale](docs/Locale.md)
 - [com.natio21.nocoiner_control.openapi.client.models.LogType](docs/LogType.md)
 - [com.natio21.nocoiner_control.openapi.client.models.MetricAnnotation](docs/MetricAnnotation.md)
 - [com.natio21.nocoiner_control.openapi.client.models.MetricsData](docs/MetricsData.md)
 - [com.natio21.nocoiner_control.openapi.client.models.MetricsReply](docs/MetricsReply.md)
 - [com.natio21.nocoiner_control.openapi.client.models.MinerConfigRaw](docs/MinerConfigRaw.md)
 - [com.natio21.nocoiner_control.openapi.client.models.MinerEvent](docs/MinerEvent.md)
 - [com.natio21.nocoiner_control.openapi.client.models.MinerFanMinCount](docs/MinerFanMinCount.md)
 - [com.natio21.nocoiner_control.openapi.client.models.MinerState](docs/MinerState.md)
 - [com.natio21.nocoiner_control.openapi.client.models.MinerStatus](docs/MinerStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ModeRaw](docs/ModeRaw.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ModeRawOneOf](docs/ModeRawOneOf.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ModeRawOneOf1](docs/ModeRawOneOf1.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ModeRawOneOf2](docs/ModeRawOneOf2.md)
 - [com.natio21.nocoiner_control.openapi.client.models.NetworkConfFile](docs/NetworkConfFile.md)
 - [com.natio21.nocoiner_control.openapi.client.models.NetworkStatus](docs/NetworkStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Overclock](docs/Overclock.md)
 - [com.natio21.nocoiner_control.openapi.client.models.OverclockSettingsRaw](docs/OverclockSettingsRaw.md)
 - [com.natio21.nocoiner_control.openapi.client.models.PasswordChange](docs/PasswordChange.md)
 - [com.natio21.nocoiner_control.openapi.client.models.PerfSummary](docs/PerfSummary.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Platform](docs/Platform.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Pool](docs/Pool.md)
 - [com.natio21.nocoiner_control.openapi.client.models.PoolStats](docs/PoolStats.md)
 - [com.natio21.nocoiner_control.openapi.client.models.PoolStatus](docs/PoolStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.PoolType](docs/PoolType.md)
 - [com.natio21.nocoiner_control.openapi.client.models.PresetSwitcherRaw](docs/PresetSwitcherRaw.md)
 - [com.natio21.nocoiner_control.openapi.client.models.RebootAfter](docs/RebootAfter.md)
 - [com.natio21.nocoiner_control.openapi.client.models.RegionalSettings](docs/RegionalSettings.md)
 - [com.natio21.nocoiner_control.openapi.client.models.SaveConfigResult](docs/SaveConfigResult.md)
 - [com.natio21.nocoiner_control.openapi.client.models.SchemaBoolEnum](docs/SchemaBoolEnum.md)
 - [com.natio21.nocoiner_control.openapi.client.models.StatusPane](docs/StatusPane.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Summary](docs/Summary.md)
 - [com.natio21.nocoiner_control.openapi.client.models.SwitchPoolQuery](docs/SwitchPoolQuery.md)
 - [com.natio21.nocoiner_control.openapi.client.models.SystemInfo](docs/SystemInfo.md)
 - [com.natio21.nocoiner_control.openapi.client.models.SystemMem](docs/SystemMem.md)
 - [com.natio21.nocoiner_control.openapi.client.models.TempRange](docs/TempRange.md)
 - [com.natio21.nocoiner_control.openapi.client.models.TempSensor](docs/TempSensor.md)
 - [com.natio21.nocoiner_control.openapi.client.models.TempSensorStatus](docs/TempSensorStatus.md)
 - [com.natio21.nocoiner_control.openapi.client.models.TimeRecord](docs/TimeRecord.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Timezone](docs/Timezone.md)
 - [com.natio21.nocoiner_control.openapi.client.models.TimezoneSettings](docs/TimezoneSettings.md)
 - [com.natio21.nocoiner_control.openapi.client.models.UiSettings](docs/UiSettings.md)
 - [com.natio21.nocoiner_control.openapi.client.models.UiTheme](docs/UiTheme.md)
 - [com.natio21.nocoiner_control.openapi.client.models.UnlockScreenBody](docs/UnlockScreenBody.md)
 - [com.natio21.nocoiner_control.openapi.client.models.UnlockSuccess](docs/UnlockSuccess.md)
 - [com.natio21.nocoiner_control.openapi.client.models.ViewConfig](docs/ViewConfig.md)
 - [com.natio21.nocoiner_control.openapi.client.models.Warranty](docs/Warranty.md)
 - [com.natio21.nocoiner_control.openapi.client.models.WarrantyStatus](docs/WarrantyStatus.md)


<a id="documentation-for-authorization"></a>
## Documentation for Authorization


Authentication schemes defined for the API:
<a id="apikeyAuth"></a>
### apikeyAuth

- **Type**: API key
- **API key parameter name**: x-api-key
- **Location**: HTTP header

<a id="bearerAuth"></a>
### bearerAuth

- **Type**: HTTP Bearer Token authentication (JWT)



## Author

support@anthill.farm
