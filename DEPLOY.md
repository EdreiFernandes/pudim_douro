# CI/CD

## How to deploy

### Database

It's hosted on Render. Its 90 days free, so is necessary to recreate it after this period.

### API
It's hosted on Render. Steps to deploy API:
- Create a PR to release;
- Complete PR;
- Before that, the deploy will start in Render.

### Web

It's hosted on Firebase. Steps to deploy web app:
- Create a PR to release;
- Complete PR;
- On the release branch, access app folder and run this command: 
```firebase deploy --project pudim-douro```