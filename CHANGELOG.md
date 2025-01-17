# Java SDK Changelog
All notable changes to this project will be documented in this file.

The format of this changelog is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).
This project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]
None

<a name="4.0.0"></a>
## [4.0.0] - 2021-05-03
### Added
- Add `verifyRequest` utility function

<a name="3.0.3"></a>
## [3.0.3] - 2020-12-16
### Added
- Add `privacyMode` option to RecordUtterance PerCL command

<a name="3.0.2"></a>
## [3.0.2] - 2020-12-16
### Added
- Additional message statuses for TFN functionality

<a name="1.2.1"></a>
## [1.2.1] - 2020-10-14
### Added
- Add `Reject` PerCL command
- Add `privacyMode` option

### Changed
- Rename `setPersyUrl` to `setUrl`

### Fixed
- Properly handle empty response bodies
- Other Minor bug fixes

<a name="1.2"></a>
## [1.2] - 2019-10-16
### Changed
- Persephony is now FreeClimb
- Code cleanup
- Documentation Updates
- Test Update

### Fixed
- Update common response handler to not use bodu twice

<a name="1.1.1"></a>
## [1.1.1] - 2019-06-27
### Changed
- Minor updates to docs and code cleanup


<a name="1.1.0"></a>
## [1.1.0] - 2019-06-07
### Pull Requests
- Merge pull request [#22](https://gitlab.vailsys.com/vail-cloud-services/fc-boilerplates/javascript-sdk/issues/22) from PersephonyAPI/maintenance


<a name="1.0.0"></a>
## [1.0.0] - 2019-06-04
### Changed
- Change default api target


<a name="0.1.0"></a>
## [0.1.0] - 2019-05-30
### Added
- `PlayEarlyMedia` PerCL Command

<a name="0.0.2"></a>
## [0.0.2] - 2018-11-29
### Remove
- Remove `callConnectUrl` and `statusCallbackUrl` from api.calls#create

<a name="0.0.1"></a>
## [0.0.1] - 2018-11-13
### Added
- PerCL Support
- FreeClimb API Support
- README, LICENSE
- docs

### Changed
- Initial Release


[Unreleased]: https://github.com/FreeClimbAPI/java-sdk/compare/v1.0.1...HEAD
