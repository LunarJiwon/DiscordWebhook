# Discord Webhook Manager

Create webhooks simply and easily

## Install
### 1. Add the JitPack repository
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
### 2. Add the dependency
```xml
<dependency>
    <groupId>com.github.LunarJiwon</groupId>
    <artifactId>DiscordWebhook</artifactId>
    <version>1.0.2</version>
</dependency>
```

## Example Java
### 1. Send to content

```java
DiscordWebhook webhook = DiscordWebhook("WebhookURL");
webhook.

setContent("Hello World!");
webhook.

execute(); // return org.jiwon.discordWebhook.DiscordResponse
```

### 2. Send to embed

```java
DiscordWebhook webhook = DiscordWebhook("WebhookURL");

DiscordEmbedBuilder discordEmbedBuilder = org.jiwon.discordWebhook.DiscordEmbedBuilder();
discordEmbedBuilder.

setTitle("Hello World!");
discordEmbedBuilder.

setDescription("Hello Description!");

DiscordEmbed discordEmbed = discordEmbedBuilder.build();

webhook.

addEmbed(discordEmbed);
webhook.

execute(); // return org.jiwon.discordWebhook.DiscordResponse
```

### 3. Exception handling

```java
DiscordWebhook webhook = DiscordWebhook("WebhookURL");
webhook.

setContent("Hello World!");

DiscordResponse discordResponse = webhook.execute(); // return org.jiwon.discordWebhook.DiscordResponse
if(discordResponse ==400){
        // Processing syntax when message sending via web hook fails.
        }
```

## Example Kotlin
### 1. Send to content
```kotlin
val webhook = org.jiwon.discordWebhook.DiscordWebhook("WebhookURL")
webhook.setContent("Hello World!")
webhook.execute() // return org.jiwon.discordWebhook.DiscordResponse
```

### 2. Send to embed
```kotlin
val webhook = org.jiwon.discordWebhook.DiscordWebhook("WebhookURL")

val discordEmbedBuilder = org.jiwon.discordWebhook.DiscordEmbedBuilder()
discordEmbedBuilder.setTitle("Hello World!")
discordEmbedBuilder.setDescription("Hello Description!")

val discordEmbed = discordEmbedBuilder.build()

webhook.addEmbed(discordEmbed)
webhook.execute() // return org.jiwon.discordWebhook.DiscordResponse
```

### 3. Exception handling
```kotlin
val webhook = org.jiwon.discordWebhook.DiscordWebhook("WebhookURL")
webhook.setContent("Hello World!")

val discordResponse = webhook.execute() // return org.jiwon.discordWebhook.DiscordResponse
if(discordResponse == 400){
    // Processing syntax when message sending via web hook fails.
}

```